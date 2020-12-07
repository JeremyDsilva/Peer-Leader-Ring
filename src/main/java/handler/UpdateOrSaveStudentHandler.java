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

            // if(response.hasException()) // attempt to reset view to old values 
            // {
            //     var resetResponse = repos.read(Long.parseLong(dto.getId()));
            //     if(resetResponse.hasException()) // will occur if database cant find the value
            //         return Response.ofException("Group has been deleted");

            //     dto.setName(resetResponse.getResponse().getName());
            //     dto.setPeerLeaderId(Long.toString(resetResponse.getResponse().getPeerLeader().getId()));
            //     dto.setTeamLeaderId(Long.toString(resetResponse.getResponse().getTeamLeader().getId()));
            // }

            return response; // return original response
        }







    }

}
