package handler;

import response.Response;
import repository.GroupRepository;

public class GetGroupCountHandler {

    public Response<Long> handler(){

        GroupRepository repository = new GroupRepository();

        return repository.count();
    }
    
}
