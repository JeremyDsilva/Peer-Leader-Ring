package handler;

import dto.Admin;
import repository.UserRepository;
import response.Response;

public class DeleteAdminHandler {

    public Response<Void> handle(Admin admin) {

        UserRepository repos = new UserRepository();

        if (repos.count("admin").getResponse() < 2)
            return Response.ofException("Atleast one admin must be registered in the system");

        return repos.delete(admin.getDatabaseObject());
    }
}
