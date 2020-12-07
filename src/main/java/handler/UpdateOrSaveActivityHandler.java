package handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import dto.Activity;
import repository.ActivityRepository;
import response.Response;

public class UpdateOrSaveActivityHandler {

    public Response<entity.Activity> handle(Activity dto) {

        ActivityRepository groupRepos = new ActivityRepository();

        var db = dto.getDatabaseObject();

        boolean newValue = db == null;

        if (db == null)
            db = new entity.Activity();

        db.setName(dto.getName());
        try {
            db.setDateOfActivity(new SimpleDateFormat("dd-MMM-yyyy").parse(dto.getDate()));
        } catch (ParseException e) {
            return Response.of(e);
        }
        db.setOrganizedBy(dto.getOrganizedby());
        db.setNote(dto.getNote());

        if (newValue) {
            var response = groupRepos.create(db);

            if (response.hasException())
                return Response.of(response.getException());

            db.setId(response.getResponse());

            return Response.of(db);
        } else {
            var response = groupRepos.update(db);
            return response; // return original response
        }

    }

}
