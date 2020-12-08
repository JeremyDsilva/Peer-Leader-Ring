package handler;

import dto.CountPerCollege;
import repository.StudentLeaderRepository;
import repository.StudentRepository;

public class CountPerCollegeHandler {

    public CountPerCollege handle() {

        StudentLeaderRepository leaderRepos = new StudentLeaderRepository();
        StudentRepository studentRepos = new StudentRepository();

        CountPerCollege data = new CountPerCollege();

        data.setLeaders(leaderRepos.countPerCollege().getResponse());

        data.setStudents(studentRepos.countPerCollege().getResponse());

        return data;
    }

}
