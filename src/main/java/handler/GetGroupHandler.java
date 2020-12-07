package handler;

import entity.Group;
import repository.GroupRepository;
import response.Response;

public class GetGroupHandler {

    public Response<Group> handle(Long groupId) {
        GroupRepository groupRepository = new GroupRepository();

        return groupRepository.read(Long.valueOf(groupId));
    }

}
