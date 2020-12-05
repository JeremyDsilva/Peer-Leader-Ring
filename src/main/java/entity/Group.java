package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the STUDENT_GROUP database table.
 * 
 */
@Entity
@Table(name="STUDENT_GROUP")
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="group")
	private List<Student> students;

	//bi-directional many-to-one association to StudentLeader
	@ManyToOne
	@JoinColumn(name="PEER_LEADER")
	private StudentLeader peerLeader;

	//bi-directional many-to-one association to StudentLeader
	@ManyToOne
	@JoinColumn(name="TEAM_LEADER")
	private StudentLeader teamLeader;

	public Group() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setGroup(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setGroup(null);

		return student;
	}

	public StudentLeader getPeerLeader() {
		return this.peerLeader;
	}

	public void setPeerLeader(StudentLeader peerLeader) {
		this.peerLeader = peerLeader;
	}

	public StudentLeader getTeamLeader() {
		return this.teamLeader;
	}

	public void setTeamLeader(StudentLeader teamLeader) {
		this.teamLeader = teamLeader;
	}

}