package dto;

import handler.DeleteGroupHandler;
import handler.GetGroupHandler;
import handler.UpdateOrSaveGroupHandler;
import response.Response;

public class Group {

    private entity.Group db;

    String id;
    String name;
    String peerLeaderId;
    String teamLeaderId;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeerLeaderId() {
        return peerLeaderId;
    }

    public void setPeerLeaderId(String peerLeaderId) {
        this.peerLeaderId = peerLeaderId;
    }

    public String getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(String teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    public Group(entity.Group dbGroup) {
        this.db = dbGroup;
        this.id = Long.toString(db.getId());
        this.name = db.getName();
        this.peerLeaderId = Long.toString(db.getPeerLeader().getId());
        this.teamLeaderId = Long.toString(db.getTeamLeader().getId());
    }

    public entity.Group getDatabaseObject() {
        return db;
    }

    public Response<Void> updateOrSave() {

        UpdateOrSaveGroupHandler handler = new UpdateOrSaveGroupHandler();

        Response<entity.Group> response;

        response = handler.handle(this);

        if (response.hasException()) 
            return Response.of(response.getException());
        else if(db == null)
            id = Long.toString(response.getResponse().getId());
      
        db = response.getResponse();

        return Response.Ok();
    }

    public Response<Void> reset() {
        if (db != null) {

            GetGroupHandler handler = new GetGroupHandler();
            var response = handler.handle(db.getId());

            if (response.hasException()) // will occur if database cant find the value
                return Response.ofException("Group has been deleted");

            setName(response.getResponse().getName());
            setPeerLeaderId(Long.toString(response.getResponse().getPeerLeader().getId()));
            setTeamLeaderId(Long.toString(response.getResponse().getTeamLeader().getId()));

        } else {
            id = "<Default>";
            setName("<Insert Name>");
            setPeerLeaderId("<Inset Peer Leader ID>");
            setTeamLeaderId("<Insert Team Leader ID>");
        }

        return Response.Ok();
    }

    public Response<Void> delete() {
        DeleteGroupHandler handler = new DeleteGroupHandler();

        return handler.handle(this);
    }

    public Group(String id, String name, String peerLeaderId, String teamLeaderId) {
        this.db = null;
        this.id = id;
        this.name = name;
        this.peerLeaderId = peerLeaderId;
        this.teamLeaderId = teamLeaderId;
    }

}
