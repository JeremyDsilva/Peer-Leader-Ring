package handler;

import repository.ActivityAttendanceRepository;
import response.Response;

public class CountAttendanceHandler {

    public Response<Long> handle()
    {
        return new ActivityAttendanceRepository().count();
    }
}
