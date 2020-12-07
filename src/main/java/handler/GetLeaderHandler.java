package handler;

import entity.StudentLeader;
import repository.StudentLeaderRepository;
import response.Response;

public class GetLeaderHandler {

    public Response<StudentLeader> handle(Long id) {

        StudentLeaderRepository repos = new StudentLeaderRepository();
        return repos.read(id);
    }

}
