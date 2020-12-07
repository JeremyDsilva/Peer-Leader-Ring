package handler;

import dto.LeaderCount;
import repository.StudentLeaderRepository;

public class LeaderCountHandler {

    public LeaderCount handle() {

        LeaderCount data = new LeaderCount();

        StudentLeaderRepository repos = new StudentLeaderRepository();

        data.setPeerLeaderCount(repos.count("peer_leader").getResponse());
        data.setTeamLeaderCount(repos.count("team_leader").getResponse());

        return data;
    }

}
