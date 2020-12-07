package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the STUDENT_LEADER database table.
 * 
 */
@Entity
@Table(name="STUDENT_LEADER")
@NamedQuery(name="StudentLeader.findAll", query="SELECT s FROM StudentLeader s")
public class StudentLeader implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="STUDENT_LEADER_ROLE")
	private String studentLeaderRole;

	@Column(name="\"YEAR\"")
	private String year;

	//bi-directional many-to-one association to Group
	@OneToMany(mappedBy="peerLeader", fetch = FetchType.EAGER)
	private List<Group> peerGroup;

	//bi-directional many-to-one association to Group
	@OneToMany(mappedBy="teamLeader", fetch = FetchType.EAGER)
	private List<Group> teamGroup;

	//bi-directional one-to-one association to User
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID")
	private User userDetail;

	//uni-directional many-to-one association to College
	// @ManyToOne
	// @JoinColumn(name="COLLEGE")
	private String college;

	public StudentLeader() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentLeaderRole() {
		return this.studentLeaderRole;
	}

	public void setStudentLeaderRole(String studentLeaderRole) {
		this.studentLeaderRole = studentLeaderRole;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Group> getPeerGroup() {
		return this.peerGroup;
	}

	public void setPeerGroup(List<Group> peerGroup) {
		this.peerGroup = peerGroup;
	}

	public Group addPeerGroup(Group peerGroup) {
		getPeerGroup().add(peerGroup);
		peerGroup.setPeerLeader(this);

		return peerGroup;
	}

	public Group removePeerGroup(Group peerGroup) {
		getPeerGroup().remove(peerGroup);
		peerGroup.setPeerLeader(null);

		return peerGroup;
	}

	public List<Group> getTeamGroup() {
		return this.teamGroup;
	}

	public void setTeamGroup(List<Group> teamGroup) {
		this.teamGroup = teamGroup;
	}

	public Group addTeamGroup(Group teamGroup) {
		getTeamGroup().add(teamGroup);
		teamGroup.setTeamLeader(this);

		return teamGroup;
	}

	public Group removeTeamGroup(Group teamGroup) {
		getTeamGroup().remove(teamGroup);
		teamGroup.setTeamLeader(null);

		return teamGroup;
	}

	public User getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(User userDetail) {
		this.userDetail = userDetail;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

}