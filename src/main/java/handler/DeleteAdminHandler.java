package handler;

import dto.Admin;
import repository.UserRepository;
import response.Response;

public class DeleteAdminHandler {

    public Response<Void> handle(Admin admin) {

        UserRepository repos = new UserRepository();

        return repos.delete(admin.getDatabaseObject());
    }
}
