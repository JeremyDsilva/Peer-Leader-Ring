package handler;

import java.util.List;

import entity.StudentLeader;
import repository.StudentLeaderRepository;
import response.Response;


public class GetLeadersHandler {
    public Response<List<StudentLeader>> handle() {

        StudentLeaderRepository studentleaderRepository = new StudentLeaderRepository();

        return studentleaderRepository.readAll();
    }
}
