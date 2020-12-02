package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STUDENT database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String active;

	//bi-directional many-to-one association to ActivityAttendance
	@OneToMany(mappedBy="student")
	private List<ActivityAttendance> attendace;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="ID")
	private User userDetail;

	//uni-directional many-to-one association to College
	@ManyToOne
	@JoinColumn(name="COLLEGE")
	private College college;

	//bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name="STUDENT_GROUP")
	private Group group;

	public Student() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public List<ActivityAttendance> getAttendace() {
		return this.attendace;
	}

	public void setAttendace(List<ActivityAttendance> attendace) {
		this.attendace = attendace;
	}

	public ActivityAttendance addAttendace(ActivityAttendance attendace) {
		getAttendace().add(attendace);
		attendace.setStudent(this);

		return attendace;
	}

	public ActivityAttendance removeAttendace(ActivityAttendance attendace) {
		getAttendace().remove(attendace);
		attendace.setStudent(null);

		return attendace;
	}

	public User getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(User userDetail) {
		this.userDetail = userDetail;
	}

	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}