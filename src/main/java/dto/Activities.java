/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

public class Activities {

    long id;
    String name;
    Date date;
    String organizedby;
    String note;    

    public Activities(long id, String name, Date date, String organizedby, String note) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.organizedby = organizedby;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
    
    
}


