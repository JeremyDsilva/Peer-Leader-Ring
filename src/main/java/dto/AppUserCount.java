package dto;

public class AppUserCount {

    Long numberOfStudents;
    Long numberOfAdmins;
    Long numberOfLeaders;

    public AppUserCount() {

    }

    public Long getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Long numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Long getNumberOfAdmins() {
        return numberOfAdmins;
    }

    public void setNumberOfAdmins(Long numberOfAdmins) {
        this.numberOfAdmins = numberOfAdmins;
    }

    public Long getNumberOfLeaders() {
        return numberOfLeaders;
    }

    public void setNumberOfLeaders(Long numberOfLeaders) {
        this.numberOfLeaders = numberOfLeaders;
    }

}
