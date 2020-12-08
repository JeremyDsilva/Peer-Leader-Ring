package handler;

import repository.ActivityRepository;
import response.Response;

public class GetActivityCountHandler {

    public Response<Long> handler(){

        ActivityRepository repository = new ActivityRepository();

        return repository.count();
    }
    
}
