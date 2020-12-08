package handler;

import entity.ActivityAttendance;
import repository.ActivityAttendanceRepository;
import response.Response;

public class DeleteAttendanceHandler {

    public Response<Void> handle(ActivityAttendance entity){

        ActivityAttendanceRepository repos = new ActivityAttendanceRepository();

        return repos.delete(entity);        
    }
    
}
