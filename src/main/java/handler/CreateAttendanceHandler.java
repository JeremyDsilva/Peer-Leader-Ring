package handler;

import entity.Activity;
import entity.ActivityAttendance;
import entity.ActivityAttendancePK;
import entity.Student;
import repository.ActivityAttendanceRepository;
import response.Response;

public class CreateAttendanceHandler {

    public Response<Void> handle(Student student, Activity activity) {

        ActivityAttendancePK pk = new ActivityAttendancePK();

        pk.setActivityId(activity.getId());
        pk.setStudentId(student.getId());

        ActivityAttendance activityAttendance = new ActivityAttendance();
        activityAttendance.setId(pk);
        
        ActivityAttendanceRepository repos = new ActivityAttendanceRepository();

        var response = repos.create(activityAttendance);

        return response.hasException() ? Response.of(response.getException()) : Response.Ok();
    }

}
