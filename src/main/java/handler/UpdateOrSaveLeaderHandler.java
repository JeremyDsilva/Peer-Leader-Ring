package handler;

import dto.Leader;
import entity.User;
import repository.StudentLeaderRepository;
import response.Response;
import util.PasswordUtil;

public class UpdateOrSaveLeaderHandler {

    public Response<entity.StudentLeader> handle(Leader dto) {

        StudentLeaderRepository repos = new StudentLeaderRepository();

        var db = dto.getDatabaseObject();

        boolean newValue = db == null;

        if (db == null) {
            db = new entity.StudentLeader();
            db.setId(Long.parseLong(dto.getId()));
            db.setUserDetail(new User());
            db.getUserDetail().setId(db.getId());
            db.getUserDetail().setUserRole("leader");
            db.getUserDetail().setPassword(PasswordUtil.getHashedPassword(dto.getId()));
        }

        db.getUserDetail().setFullName(dto.getName());
        db.getUserDetail().setEmail(dto.getEmail());
        db.getUserDetail().setPhoneNumber(dto.getPhone());
        db.setCollege(dto.getCollege());
        db.setYear(dto.getYear());
        db.setStudentLeaderRole(dto.getRole());

        if (newValue) {
            var response = repos.create(db);

            if (response.hasException())
                return Response.of(response.getException());

            return Response.of(db);
        } else {
            var response = repos.update(db);

            return response; // return original response
        }
    }

}
