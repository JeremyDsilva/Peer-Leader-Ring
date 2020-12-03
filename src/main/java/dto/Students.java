package dto;

public class Students {

    long id;

    String name;

    String college;

    String email;

    String phone;

    long groupid;

    

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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setGroupid(long groupid){
        this.groupid = groupid;
    }

    public long getGroupid(){
        return groupid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Students(long id, String name, String college, String email, String phone) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.email = email;
        this.phone = phone;
    }
    public Students(long id, String name, String college, String email, String phone,  long groupid ) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.email = email;
        this.phone = phone;
        this.groupid = groupid;
    }

  
}