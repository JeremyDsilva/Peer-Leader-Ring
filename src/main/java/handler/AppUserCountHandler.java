package handler;

import dto.AppUserCount;
import repository.UserRepository;

public class AppUserCountHandler {

    public AppUserCount handle() {

        UserRepository repos = new UserRepository();

        AppUserCount data = new AppUserCount();

        data.setNumberOfAdmins(repos.count("admin").getResponse());
        data.setNumberOfLeaders(repos.count("leader").getResponse());
        data.setNumberOfStudents(repos.count("student").getResponse());

        return data;
    }

}
