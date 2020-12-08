package handler;

import dto.Student;
import entity.User;
import repository.GroupRepository;
import repository.StudentRepository;
import response.Response;
import util.PasswordUtil;

public class UpdateOrSaveStudentHandler {

    public Response<entity.Student> handle(Student dto) {

        try {
            StudentRepository repos = new StudentRepository();

            var db = dto.getDatabaseObject();

            boolean newValue = db == null;

            if (db == null) {
                db = new entity.Student();
                db.setUserDetail(new User());
                db.setId(Long.parseLong(dto.getId()));
                db.getUserDetail().setId(db.getId());
                db.getUserDetail().setPassword(PasswordUtil.getHashedPassword(dto.getId()));
                db.getUserDetail().setUserRole("student");
            }

            db.getUserDetail().setFullName(dto.getName());
            db.getUserDetail().setEmail(dto.getEmail());
            db.getUserDetail().setPhoneNumber(dto.getPhone());
            db.setCollege(dto.getCollege());

            if (newValue || !db.getGroup().getName().equals(dto.getGroupName())) {
                GroupRepository groupRepos = new GroupRepository();

                var response = groupRepos.read(dto.getGroupName());

                if (response.hasException())
                    return Response.of(response.getException());

                db.setGroup(response.getResponse());
            }

            if (newValue) {
                var response = repos.create(db);

                if (response.hasException())
                    return Response.of(response.getException());

                return Response.of(db);
            } else {
                var response = repos.update(db);

                return response; // return original response
            }

        } catch (Exception e) {
            return Response.of(e);
        }

    }

}
