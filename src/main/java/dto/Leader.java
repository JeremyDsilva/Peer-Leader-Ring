package dto;

import handler.DeleteLeaderHandler;
import handler.GetLeaderHandler;
import handler.UpdateOrSaveLeaderHandler;
import response.Response;

public class Leader {

    entity.StudentLeader db;

    String id;
    String college;
    String year;
    String role;
    String email;
    String phone;
    String name;

    public Leader(String id, String name, String college, String year, String role, String email, String phone) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.year = year;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }

    public Leader(entity.StudentLeader db) {
        this.db = db;
        id = Long.toString(db.getId());
        name = db.getUserDetail().getFullName();
        college = db.getCollege();
        year = db.getYear();
        role = db.getStudentLeaderRole();
        email = db.getUserDetail().getEmail();
        phone = db.getUserDetail().getPhoneNumber();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public entity.StudentLeader getDatabaseObject() {
        return db;
    }

    public Response<Void> updateOrSave() {

        UpdateOrSaveLeaderHandler handler = new UpdateOrSaveLeaderHandler();

        Response<entity.StudentLeader> response;

        response = handler.handle(this);

        if (response.hasException()) {
            return Response.of(response.getException());
        }

        db = response.getResponse();

        return Response.Ok();
    }

    public Response<Void> reset() {
        if (db != null) {

            GetLeaderHandler handler = new GetLeaderHandler();
            var response = handler.handle(db.getId());

            if (response.hasException()) // will occur if database cant find the value
                return Response.ofException("Student has been deleted");

            setName(response.getResponse().getUserDetail().getFullName());
            setCollege(response.getResponse().getCollege());
            setEmail(response.getResponse().getUserDetail().getEmail());
            setPhone(response.getResponse().getUserDetail().getPhoneNumber());
            setYear(response.getResponse().getYear());
            setRole(response.getResponse().getStudentLeaderRole());

        } else {
            setId("<Insert>");
            setName("<Insert>");
            setCollege("<Insert>");
            setEmail("<Insert>");
            setPhone("<Insert>");
            setYear("<Insert>");
            setRole("<Insert>");
        }

        return Response.Ok();
    }

    public Response<Void> delete() {
        DeleteLeaderHandler handler = new DeleteLeaderHandler();

        return handler.handle(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
