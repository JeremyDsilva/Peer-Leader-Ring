package handler;

import app.AppContext;
import repository.UserRepository;
import response.Response;
import util.PasswordUtil;

public class ChangePasswordHandler {

    public Response<Void> handle(String oldPassword, String newPassword){

        LoginHandler loginHandler = new LoginHandler();

        UserRepository userRepository = new UserRepository();

        var response = loginHandler.handle(AppContext.getUser().getId(), oldPassword);

        if(response.hasException())
            return Response.ofException("Incorrect password");
        
        response.getResponse().setPassword(PasswordUtil.getHashedPassword(newPassword));

        var _response = userRepository.update(response.getResponse());

        if(_response.hasException())
            return Response.of(_response.getException());
        
        return Response.Ok();
    }
    
   


}
