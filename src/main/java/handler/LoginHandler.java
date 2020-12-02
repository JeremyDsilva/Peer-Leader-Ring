package handler;

import app.AppContext;
import entity.User;
import repository.UserRepository;
import response.Response;

public class LoginHandler {

    public Response<User> handle(Long id, String password)
    {
        UserRepository userRepository = new UserRepository();

        Response<User> response = userRepository.read(id);

        if(response.hasException())
            return Response.of(response.getException());

        User user = response.getResponse();
        
        if(!user.getPassword().equals(password))
            return Response.of(new Exception("Incorrect Username or Password"));

        AppContext.setUser(user);
       
        return Response.of(user);     
    }
    
}
