package jpa.dao;

import java.util.List;

import jpa.entitymodels.Student;

public interface StudentDAO {

	List<Student> getAllStudents();

	Student getStudentByEmail(Student student);

	Student validateStudent(Student student);

	List<Student> getStudentCourses(Student student);

//	boolean registerStudentToCourse(Student student);

	boolean registerStudentToCourse(String email, int cid);
}
