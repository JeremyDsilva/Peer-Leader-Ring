package handler;

import entity.User;
import repository.UserRepository;
import response.Response;

public class GetAdminHandler {
    
    public Response<User> handle(Long id) {

        UserRepository studentRepository = new UserRepository();

        return studentRepository.read(id);

    }
}