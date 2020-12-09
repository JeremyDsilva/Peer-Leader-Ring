package handler;

import app.AppContext;
import entity.User;
import repository.UserRepository;
import response.Response;
import util.PasswordUtil;

public class LoginHandler {

    public Response<User> handle(Long id, String password)
    {
        UserRepository userRepository = new UserRepository();

        Response<User> response = userRepository.read(id);

        if(response.hasException())
            return Response.of(response.getException());

        User user = response.getResponse();

        if(user == null)
            return Response.ofException("Incorrect Username or Password");

        if(!PasswordUtil.comparePassword(user.getPassword(), password))
            return Response.ofException("Incorrect Username or Password");

        AppContext.setUser(user);
       
        return Response.of(user);     
    }
    
}
