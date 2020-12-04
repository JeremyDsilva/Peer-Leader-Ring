package dto;

public class Students {

    long id;

    String name;

    String college;

    String email;

    String phone;

    String gname;

    

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
    public Students(long id, String name, String college, String email, String phone,  String gname ) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.email = email;
        this.phone = phone;
        this.gname = gname;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

  
}