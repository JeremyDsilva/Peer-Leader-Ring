package handler;

import entity.Activity;
import entity.ActivityAttendance;
import entity.Student;
import repository.ActivityAttendanceRepository;
import response.Response;

public class CreateAttendanceHandler {

    public Response<Void> handle(Student student, Activity activity) {

        ActivityAttendance activityAttendance = new ActivityAttendance();

        activityAttendance.setActivity(activity);
        activityAttendance.setStudent(student);

        ActivityAttendanceRepository repos = new ActivityAttendanceRepository();

        var response = repos.create(activityAttendance);

        return response.hasException() ? Response.of(response.getException()) : Response.Ok();
    }

}
