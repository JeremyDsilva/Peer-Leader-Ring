package handler;

import java.util.List;

import entity.User;
import repository.UserRepository;
import response.Response;

public class GetAdminsHanlder {

    public Response<List<User>> handle(Long groupId) {

        UserRepository userRepository = new UserRepository();

        return userRepository.readAll("admin");

    }

}
