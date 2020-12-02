package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COLLEGE database table.
 * 
 */
@Entity
@NamedQuery(name="College.findAll", query="SELECT c FROM College c")
public class College implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="COLLEGE_NAME")
	private String collegeName;

	public College() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

}