package handler;

import repository.GroupRepository;
import repository.StudentLeaderRepository;
import response.Response;

public class UpdateOrSaveGroupHandler {

    public Response<entity.Group> handle(dto.Group dto) {

        GroupRepository groupRepos = new GroupRepository();

        var db = dto.getDatabaseObject();

        boolean newValue = db == null;

        if (db == null)
            db = new entity.Group();

        db.setName(dto.getName());

        StudentLeaderRepository leaderRepos = null;

        if (newValue || !Long.toString(db.getPeerLeader().getId()).equals(dto.getPeerLeaderId())) {

            leaderRepos = new StudentLeaderRepository();

            var response = leaderRepos.read(Long.parseLong(dto.getPeerLeaderId()));

            if (response.hasException())
                return Response.of(response.getException());

            var peerLeader = response.getResponse();
            if (peerLeader.getStudentLeaderRole().equals("team_leader")) // is a peer leader
                return Response.ofException("Student Leader Id entered is not a Peer Leader");

            if (!peerLeader.getPeerGroup().isEmpty()) // already has a group
                return Response.ofException("Peer Leader is already been assigned a group");

            db.setPeerLeader(response.getResponse());
        }

        if (newValue || !Long.toString(db.getTeamLeader().getId()).equals(dto.getTeamLeaderId())) {

            if (leaderRepos == null)
                leaderRepos = new StudentLeaderRepository();

            var response = leaderRepos.read(Long.parseLong(dto.getTeamLeaderId()));

            if (response.hasException())
                return Response.of(response.getException());

            var teamLeader = response.getResponse();

            if (teamLeader.getStudentLeaderRole().equals("peer_leader")) // is a team leader
                return Response.ofException("Student Leader Id entered is not a Team Leader");

            db.setTeamLeader(response.getResponse());
        }

        if (newValue) {
            var response = groupRepos.create(db);

            if (response.hasException())
                return Response.of(response.getException());

            db.setId(response.getResponse());

            return Response.of(db);
        } else {
            var response = groupRepos.update(db);

            // if(response.hasException()) // attempt to reset view to old values 
            // {
            //     var resetResponse = groupRepos.read(Long.parseLong(dto.getId()));
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
