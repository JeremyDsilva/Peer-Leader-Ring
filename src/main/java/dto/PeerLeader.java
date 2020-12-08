package dto;

public class PeerLeader {
    long pid;
    String pname;
    String pphone;
    String pemail;
    String pgroupname;
    Long groupId;

    public PeerLeader(long pid, String pname, String pphone, String pemail, String pgroupname, Long groupId) {
        this.pid = pid;
        this.pname = pname;
        this.pphone = pphone;
        this.pemail = pemail;
        this.pgroupname = pgroupname;
        this.groupId = groupId;
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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

}
