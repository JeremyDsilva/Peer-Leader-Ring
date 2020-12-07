package dto;

import handler.DeleteAdminHandler;
import handler.GetAdminHandler;
import handler.UpdateOrSaveAdminHandler;
import response.Response;

public class Admin {

    public entity.User db;

    String id;

    String name;

    String email;

    String phone;

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

    public Admin(String id, String name, String email, String phone) {
        this.db = null;
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    public Admin(entity.User user){
        this.db = user;
        this.id = Long.toString(user.getId());
        this.name = user.getFullName();
        this.email = user.getEmail();
        this.phone = user.getPhoneNumber();
    }
    
    public Response<Void> updateOrSave() {

        UpdateOrSaveAdminHandler handler = new UpdateOrSaveAdminHandler();

        Response<entity.User> response;

        response = handler.handle(this);

        if (response.hasException()) {
            return Response.of(response.getException());
        }

        db = response.getResponse();

        return Response.Ok();
    }

    public Response<Void> reset() {
        if (db != null) {

            GetAdminHandler handler = new GetAdminHandler();
            var response = handler.handle(db.getId());

            if (response.hasException()) // will occur if database cant find the value
                return Response.ofException("Admin has been deleted");

            setName(response.getResponse().getFullName());
            setEmail(response.getResponse().getEmail());
            setPhone(response.getResponse().getPhoneNumber());

        } else {
            setId("<Insert>");
            setName("<Insert>");
            setEmail("<Insert>");
            setPhone("<Insert>");
        }

        return Response.Ok();
    }

    public entity.User getDatabaseObject() {
        return db;
    }

    public Response<Void> delete() {
        DeleteAdminHandler handler = new DeleteAdminHandler();

        return handler.handle(this);
    }


}
