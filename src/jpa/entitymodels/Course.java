package jpa.entitymodels;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery (query = "SELECT e FROM Course e", name = "queryCoursesAll")
public class Course {
	
	
	@Id
	@Column(name = "id")
	private int cId;
	
	@Basic
	@Column(name = "name")
	private String cName;
	
	@Basic
	@Column(name = "instructor")
	private String cInstructorName;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcInstructorName() {
		return cInstructorName;
	}

	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}

	public Course(int cId, String cName, String cInstructorName) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format("%-4s%-30s%-30s", cId, cName, cInstructorName);
	}
}
