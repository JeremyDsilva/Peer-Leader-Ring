package handler;

import java.util.List;

import app.AppContext;
import dto.Students;
import entity.Group;
import entity.StudentLeader;
import repository.GroupRepository;
import response.Response;

public class GetGroupHandler {

    public Response<Group> handle(Long groupId) {

        StudentLeader leader = AppContext.getUser().getStudentLeader();
        Group group = null;

        if (leader.getStudentLeaderRole().equals("peer_leader")) {
            groupId = leader.getPeerGroup().get(0).getId();
        }

        GroupRepository groupRepository = new GroupRepository();
        
        return groupRepository.read(Long.valueOf(groupId));

    }

}
