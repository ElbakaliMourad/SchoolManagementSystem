package jpa.entitymodels;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries ({
@NamedQuery (query = "SELECT e FROM Student e", name = "queryStudentsAll"),
@NamedQuery (query = "Select e From Student e WHERE e.sEmail = :psEmail", name = "queryStudentByEmail"), 
//@NamedQuery (query = "Select e From Student e WHERE e.sPassword = :psPassword", name = "queryStudentPassword"),
@NamedQuery (query = "Select e From Student e WHERE e.sEmail = :psEmail", name = "queryStudentCourses") 
})
public class Student {
	
	@Id
	@Column(name = "email")
	private String sEmail;
	
	@Basic
	@Column(name = "name")
	private String sName;

	@Basic
	@Column(name = "password")
	private String sPassword;

	@OneToMany
	private List<Course> sCourses = new ArrayList<Course>();

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}
	
	public Student(String sEmail, String sName, String sPassword, List<Course> sCourses) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPassword = sPassword;
		this.sCourses = sCourses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format("%-30s%-30s", sEmail, sName);
	}
}
