package handler;

import dto.AppUserCount;
import repository.UserRepository;

public class AppUserCountHandler {

    public AppUserCount handle() {

        UserRepository repos = new UserRepository();

        AppUserCount data = new AppUserCount();

        data.setNumberOfAdmins(repos.count("admin").getResponse());
        data.setNumberOfAdmins(repos.count("leader").getResponse());
        data.setNumberOfAdmins(repos.count("student").getResponse());

        return data;
    }

}
