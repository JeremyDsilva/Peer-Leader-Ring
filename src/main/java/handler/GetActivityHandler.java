package handler;

import entity.Activity;
import repository.ActivityRepository;
import response.Response;

public class GetActivityHandler {

    public Response<Activity> handle(Long id) {

        ActivityRepository repos = new ActivityRepository();

        return repos.read(id);
    }

}
