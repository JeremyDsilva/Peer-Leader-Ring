package handler;

import dto.Activity;
import repository.ActivityRepository;
import response.Response;

public class DeleteActivityHandler {

        public Response<Void> handle(Activity activity) {

                ActivityRepository repos = new ActivityRepository();

                return repos.delete(activity.getDatabaseObject());
        }

}
