package dto;

import java.util.ArrayList;
import java.util.List;

public class CountPerCollege {

    List<Object[]> _leaders;

    List<Object[]> _students;

    public List<Object[]> getLeaders() {
        return _leaders;
    }

    public void setLeaders(List<Object> leaders) {
        this._leaders = new ArrayList<Object[]>();

        leaders.forEach(leader -> this._leaders.add((Object[]) leader));
    }

    public List<Object[]> getStudents() {
        return _students;
    }

    public void setStudents(List<Object> students) {
        this._students = new ArrayList<Object[]>();

        students.forEach(leader -> this._students.add((Object[]) leader));
    }

}
