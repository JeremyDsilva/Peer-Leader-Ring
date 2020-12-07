package handler;

import dto.Leaders;
import entity.StudentLeader;
import repository.StudentLeaderRepository;
import response.Response;

public class UpdateLeaderHandler {

    public Response<StudentLeader> handle(Leaders dto) {

        StudentLeaderRepository repos = new StudentLeaderRepository();

        var response = repos.read(dto.getId());

        if (response.hasException())
            return response;

        var dbStudent = response.getResponse();

        // college

        dbStudent.setYear(dto.getYear());

        dbStudent.setStudentLeaderRole(dto.getRole());

        dbStudent.getUserDetail().setEmail(dto.getEmail());

        dbStudent.getUserDetail().setPhoneNumber(dto.getPhone());

        return repos.update(dbStudent);

    }

    public static void main(String[] args) {

        UpdateLeaderHandler handler = new UpdateLeaderHandler();

        Leaders leader = new Leaders(12345, "CEN", "Junior", "team_leader", "update@aus.edu", "971560100203");
        handler.handle(leader);

        System.out.println("Done!");

    }

}
