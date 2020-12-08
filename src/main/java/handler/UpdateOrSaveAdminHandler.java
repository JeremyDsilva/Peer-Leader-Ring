package handler;

import dto.Admin;
import repository.UserRepository;
import response.Response;
import util.PasswordUtil;

public class UpdateOrSaveAdminHandler {

    public Response<entity.User> handle(Admin dto) {

        UserRepository repos = new UserRepository();

        var db = dto.getDatabaseObject();

        boolean newValue = db == null;

        if (db == null) {
            db = new entity.User();
            db.setId(Long.parseLong(dto.getId()));
            db.setPassword(PasswordUtil.getHashedPassword(dto.getId()));
            db.setUserRole("admin");
        }

        db.setFullName(dto.getName());
        db.setEmail(dto.getEmail());
        db.setPhoneNumber(dto.getPhone());

        if (newValue) {
            var response = repos.create(db);

            if (response.hasException())
                return Response.of(response.getException());

            return Response.of(db);
        } else {
            var response = repos.update(db);

            return response;
        }

    }
}
