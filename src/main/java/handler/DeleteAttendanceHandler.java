package handler;

import entity.Activity;
import entity.ActivityAttendance;
import entity.ActivityAttendancePK;
import entity.Student;
import repository.ActivityAttendanceRepository;
import response.Response;

public class DeleteAttendanceHandler {

    public Response<Void> handle(Student student, Activity activity){

        ActivityAttendancePK pk = new ActivityAttendancePK();

        pk.setActivityId(activity.getId());
        pk.setStudentId(student.getId());

        ActivityAttendanceRepository repos = new ActivityAttendanceRepository();

        ActivityAttendance activityAttendance = new ActivityAttendance();
        activityAttendance.setId(pk);

        return repos.delete(activityAttendance);        
    }
    
}
