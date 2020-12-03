package handler;

import java.util.List;

import entity.Group;
import repository.GroupRepository;
import response.Response;

public class GetGroupsHandler {
    public Response<List<Group>> handle() {

        GroupRepository studentleaderRepository = new GroupRepository();

        return studentleaderRepository.readAll();
    }
    
}
