package dto;

import entity.Student;
import entity.Activity;
import java.util.HashMap;

public class Attendace {

    Student student;

    HashMap<Activity, Boolean> activity;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public HashMap<Activity, Boolean> getActivity() {
        return activity;
    }

    public void setActivity(HashMap<Activity, Boolean> activity) {
        this.activity = activity;
    }

    public Attendace() {

    }

    public Attendace(entity.Student student) {
        this.student = student;
        this.activity = new HashMap<>();

        student.getAttendace()
                .forEach(attendance -> this.activity.put(attendance.getActivity(), Boolean.valueOf(true)));
    }

}
