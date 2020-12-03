package handler;

import java.util.List;

import entity.Activity;
import repository.ActivityRepository;
import response.Response;

public class GetActivitiesHandler {

    public Response<List<Activity>> handle() {

        ActivityRepository activityRepository = new ActivityRepository();

        return activityRepository.readAll();
    }
}
