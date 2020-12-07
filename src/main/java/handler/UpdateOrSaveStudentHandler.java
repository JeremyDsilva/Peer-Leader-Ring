package handler;

import dto.Student;
import repository.GroupRepository;
import repository.StudentRepository;
import response.Response;

public class UpdateOrSaveStudentHandler {

    public Response<entity.Student> handle(Student dto) {

        StudentRepository repos = new StudentRepository();

        var db = dto.getDatabaseObject();

        boolean newValue = db == null;

        if (db == null) {
            db = new entity.Student();
            db.setId(Long.parseLong(dto.getId()));
        }

        db.getUserDetail().setFullName(dto.getName());
        db.getUserDetail().setEmail(dto.getEmail());
        db.getUserDetail().setPhoneNumber(dto.getPhone());
        db.setCollege(dto.getCollege());

        if (newValue || !db.getGroup().getName().equals(dto.getGroupName())) {
            GroupRepository groupRepos = new GroupRepository();

            var response = groupRepos.read(dto.getGroupName());

            if(response.hasException())
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

    }

}