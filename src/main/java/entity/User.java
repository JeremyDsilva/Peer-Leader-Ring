package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the APP_USER database table.
 * 
 */
@Entity
@Table(name = "APP_USER")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String email;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USER_ROLE")
	private String userRole;

	// bi-directional one-to-one association to Student
	@OneToOne(mappedBy = "userDetail")
	private Student student;

	// bi-directional one-to-one association to StudentLeader
	@OneToOne(mappedBy = "userDetail")
	private StudentLeader studentLeader;

	public User() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentLeader getStudentLeader() {
		return this.studentLeader;
	}

	public void setStudentLeader(StudentLeader studentLeader) {
		this.studentLeader = studentLeader;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}