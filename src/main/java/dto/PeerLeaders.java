/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Yash Gaikwad
 */
public class PeerLeaders {
    long pid;
    String pname;
    String pphone;
    String pemail;
    String pgroupname;

    public PeerLeaders(long pid, String pname, String pphone, String pemail, String pgroupname) {
        this.pid = pid;
        this.pname = pname;
        this.pphone = pphone;
        this.pemail = pemail;
        this.pgroupname = pgroupname;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    public String getPgroupname() {
        return pgroupname;
    }

    public void setPgroupname(String pgroupname) {
        this.pgroupname = pgroupname;
    }
    
    
}
