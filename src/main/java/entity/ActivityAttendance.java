package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ACTIVITY_ATTENDANCE database table.
 * 
 */
@Entity
@Table(name="ACTIVITY_ATTENDANCE")
@NamedQuery(name="ActivityAttendance.findAll", query="SELECT a FROM ActivityAttendance a")
public class ActivityAttendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ActivityAttendancePK id;

	private String feedback;

	private BigDecimal rating;

	//bi-directional many-to-one association to Activity
	@ManyToOne
	private Activity activity;

	//bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	public ActivityAttendance() {
	}

	public ActivityAttendancePK getId() {
		return this.id;
	}

	public void setId(ActivityAttendancePK id) {
		this.id = id;
	}

	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public BigDecimal getRating() {
		return this.rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}