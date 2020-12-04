package handler;

import java.util.List;

import entity.Group;
import repository.GroupRepository;
import response.Response;

public class GetGroupsUnderLeaderHandler {

    public Response<List<Group>> handle(Long leaderId) {

        GroupRepository repository = new GroupRepository();

        return repository.groupsUnderLeader(leaderId);
    }
    
}
