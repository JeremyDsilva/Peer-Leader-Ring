package handler;

import dto.Leader;
import repository.StudentLeaderRepository;
import response.Response;

public class DeleteLeaderHandler {

    public Response<Void> handle(Leader leader) {

        StudentLeaderRepository repos = new StudentLeaderRepository();

        return repos.delete(leader.getDatabaseObject());
    }

}
