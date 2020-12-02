package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ACTIVITY database table.
 * 
 */
@Entity
@NamedQuery(name="Activity.findAll", query="SELECT a FROM Activity a")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_ACTIVITY")
	private Date dateOfActivity;

	private String name;

	private String note;

	@Column(name="ORGANIZED_BY")
	private String organizedBy;

	//bi-directional many-to-one association to ActivityAttendance
	@OneToMany(mappedBy="activity", cascade={CascadeType.ALL})
	private List<ActivityAttendance> attendance;

	public Activity() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateOfActivity() {
		return this.dateOfActivity;
	}

	public void setDateOfActivity(Date dateOfActivity) {
		this.dateOfActivity = dateOfActivity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOrganizedBy() {
		return this.organizedBy;
	}

	public void setOrganizedBy(String organizedBy) {
		this.organizedBy = organizedBy;
	}

	public List<ActivityAttendance> getAttendance() {
		return this.attendance;
	}

	public void setAttendance(List<ActivityAttendance> attendance) {
		this.attendance = attendance;
	}

	public ActivityAttendance addAttendance(ActivityAttendance attendance) {
		getAttendance().add(attendance);
		attendance.setActivity(this);

		return attendance;
	}

	public ActivityAttendance removeAttendance(ActivityAttendance attendance) {
		getAttendance().remove(attendance);
		attendance.setActivity(null);

		return attendance;
	}

}