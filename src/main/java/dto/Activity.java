/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.text.SimpleDateFormat;

import handler.DeleteActivityHandler;
import handler.GetActivityHandler;
import handler.UpdateOrSaveActivityHandler;
import response.Response;

public class Activity {

    entity.Activity db;

    String id;
    String name;
    String date;
    String organizedby;
    String note;

    public Activity(String id, String name, String date, String organizedby, String note) {
        this.db = null;
        this.id = id;
        this.name = name;
        this.date = date;
        this.organizedby = organizedby;
        this.note = note;
    }

    public Activity(entity.Activity activity) {
        this.db = activity;
        this.id = Long.toString(activity.getId());
        this.name = activity.getName();
        this.date = new SimpleDateFormat("dd-MMM-yyyy").format(activity.getDateOfActivity());
        this.organizedby = activity.getOrganizedBy();
        this.note = activity.getNote();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrganizedby() {
        return organizedby;
    }

    public void setOrganizedby(String organizedby) {
        this.organizedby = organizedby;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public entity.Activity getDatabaseObject() {
        return db;
    }

    public Response<Void> updateOrSave() {

        UpdateOrSaveActivityHandler handler = new UpdateOrSaveActivityHandler();

        Response<entity.Activity> response;

        response = handler.handle(this);

        if (response.hasException())
            return Response.of(response.getException());
        else if (db == null)
            id = Long.toString(response.getResponse().getId());

        db = response.getResponse();

        return Response.Ok();
    }

    public Response<Void> reset() {
        if (db != null) {

            GetActivityHandler handler = new GetActivityHandler();
            var response = handler.handle(db.getId());

            if (response.hasException()) // will occur if database cant find the value
                return Response.ofException("Group has been deleted");

            setName(db.getName());
            setDate(new SimpleDateFormat("dd-MMM-yyyy").format(db.getDateOfActivity()));
            setOrganizedby(db.getOrganizedBy());
            setNote(db.getNote());
        } else {
            id = "<Insert>";
            setName("<Insert>");
            setDate("<Insert>");
            setOrganizedby("<Insert>");
            setNote("<Insert>");
        }

        return Response.Ok();
    }

    public Response<Void> delete() {
        DeleteActivityHandler handler = new DeleteActivityHandler();

        return handler.handle(this);
    }

}
