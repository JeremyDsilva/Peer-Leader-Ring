package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ACTIVITY_ATTENDANCE database table.
 * 
 */
@Embeddable
public class ActivityAttendancePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ACTIVITY_ID", insertable=false, updatable=false)
	private long activityId;

	@Column(name="STUDENT_ID", insertable=false, updatable=false)
	private long studentId;

	public ActivityAttendancePK() {
	}
	public long getActivityId() {
		return this.activityId;
	}
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}
	public long getStudentId() {
		return this.studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ActivityAttendancePK)) {
			return false;
		}
		ActivityAttendancePK castOther = (ActivityAttendancePK)other;
		return 
			(this.activityId == castOther.activityId)
			&& (this.studentId == castOther.studentId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.activityId ^ (this.activityId >>> 32)));
		hash = hash * prime + ((int) (this.studentId ^ (this.studentId >>> 32)));
		
		return hash;
	}
}