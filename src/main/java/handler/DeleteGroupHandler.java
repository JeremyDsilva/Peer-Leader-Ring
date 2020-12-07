package handler;

import dto.Group;
import repository.GroupRepository;
import response.Response;

public class DeleteGroupHandler {

        public Response<Void> handle(Group group) {

                GroupRepository repos = new GroupRepository();

                var response = repos.read(group.getDatabaseObject().getId());

                if (response.hasException())
                        return Response.of(response.getException());

                var dbGroup = response.getResponse();

                if (0 < dbGroup.getStudents().size()) {
                        return Response.ofException("Group cannot be deleted it has students in it");
                }

                dbGroup.setPeerLeader(null);
                dbGroup.setTeamLeader(null);

                return repos.delete(dbGroup);
        }

}
