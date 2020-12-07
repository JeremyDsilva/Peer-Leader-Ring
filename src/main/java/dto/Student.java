package dto;

import handler.DeleteStudentHandler;
import handler.GetStudentHandler;
import handler.UpdateOrSaveStudentHandler;
import response.Response;

public class Student {

    private entity.Student db;

    String id;

    String name;

    String college;

    String email;

    String phone;

    String groupName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student(String id, String name, String college, String email, String phone, String groupName) {
        this.db = null;
        this.id = id;
        this.name = name;
        this.college = college;
        this.email = email;
        this.phone = phone;
        this.groupName = groupName;
    }

    public Student(entity.Student student) {
        this.db = student;
        this.id = Long.toString(student.getId());
        this.name = student.getUserDetail().getFullName();
        this.college = student.getCollege();
        this.email = student.getUserDetail().getEmail();
        this.phone = student.getUserDetail().getPhoneNumber();
        this.groupName = student.getGroup().getName();
    }

    public Response<Void> updateOrSave() {

        UpdateOrSaveStudentHandler handler = new UpdateOrSaveStudentHandler();

        Response<entity.Student> response;

        response = handler.handle(this);

        if (response.hasException()) {
            return Response.of(response.getException());
        }

        db = response.getResponse();

        return Response.Ok();
    }

    public Response<Void> reset() {
        if (db != null) {

            GetStudentHandler handler = new GetStudentHandler();
            var response = handler.handle(db.getId());

            if (response.hasException()) // will occur if database cant find the value
                return Response.ofException("Student has been deleted");

            setName(response.getResponse().getUserDetail().getFullName());
            setCollege(response.getResponse().getCollege());
            setEmail(response.getResponse().getUserDetail().getEmail());
            setPhone(response.getResponse().getUserDetail().getPhoneNumber());
            setGroupName(response.getResponse().getGroup().getName());

        } else {
            setId("<Insert>");
            setName("<Insert>");
            setCollege("<Insert>");
            setEmail("<Insert>");
            setPhone("<Insert>");
            setGroupName("<Insert>");
        }

        return Response.Ok();
    }

    public entity.Student getDatabaseObject() {
        return db;
    }

    public Response<Void> delete() {
        DeleteStudentHandler handler = new DeleteStudentHandler();

        return handler.handle(this);
    }

}