package jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO {

	@Override
	public List<Student> getAllStudents() {
		
	List<Student> studentList = new ArrayList<>();		
	EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("SMS");
	EntityManager entitymanager = entitymanagerfactory.createEntityManager();
	
//	Query query = entitymanager.createQuery("SELECT e FROM Student e");
	Query query = entitymanager.createNamedQuery("queryStudentsAll");
	studentList = query.getResultList();
	
	entitymanager.close();
	entitymanagerfactory.close();
	
	return studentList;
	}
	
	@Override
	public Student getStudentByEmail(Student student) {
		Student foundStudent = null;
		
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {		
			foundStudent = entitymanager.find(Student.class, student.getsEmail());
		} catch(PersistenceException e) {
				e.getMessage();
		}
		finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}		
		return foundStudent;
	}
		
	public Student getStudentPassword(Student student) {
		Student foundStudent = null;
		
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {		
			foundStudent = entitymanager.find(Student.class, student.getsPassword());
		} catch(PersistenceException e) {
				e.getMessage();
		}
		finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}		
		return foundStudent;
	}

	@Override
	public Student validateStudent(Student student) {
		Student foundStudent = null;
		
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {
			foundStudent = entitymanager.find(Student.class, student.getsEmail());
			String pass = foundStudent.getsPassword();
			if (student.getsPassword().equals(pass)) {
				return foundStudent;
			}
			else
				return null;
		} catch(PersistenceException e) {
				e.getMessage();
				return null;
		}
		finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}		
	}

	@Override
	public List<Student> getStudentCourses(Student student) {

		List<Student> studentList = new ArrayList<>();
		
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		
//		Query query = entitymanager.createQuery("Select e From Student e WHERE e.email = :pemail");
		Query query = entitymanager.createNamedQuery("queryStudentCourses");

		query.setParameter("psEmail", student.getsEmail());
		studentList = query.getResultList();
		
		entitymanager.close();
		entitymanagerfactory.close();
		
		return studentList;
	}
	
	@Override
	public boolean registerStudentToCourse(String email, int cid) {
		boolean result = true;
		
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {		
		entitymanager.getTransaction().begin();	
		Student foundStudent = entitymanager.find(Student.class, email);
		List<Course> crs = new ArrayList<>();
		crs = foundStudent.getsCourses();
		foundStudent.setsCourses(crs);

//	foundStudent = find
//	list = foundStudent.getsCourses
//	list.add(cid)
//	foundStudent.setScourses(list)
		
		entitymanager.persist(foundStudent);	
		entitymanager.getTransaction().commit();

		} catch(PersistenceException e) {
				e.getMessage();
				System.out.println(e.toString());
				result = false;
		}
		finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}		
		return result;
	}

//	@Override
//	public boolean registerStudentToCourse(Student student) {
//		boolean result = true;
//		
//		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("SMS");
//		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
//		try {		
//		entitymanager.getTransaction().begin();	
//		Student foundStudent = entitymanager.find(Student.class, student.getsEmail());
//		List<Course> studentCrs = new ArrayList<>();
//		studentCrs = foundStudent.getsCourses();
//		studentCrs.add(student.getsCourses());
//		
////		foundStudent = find
////		list = foundStudent.getsCourses
////		list.add(cid)
////		student.setScourses(list)
//		entitymanager.persist(student);		
//		entitymanager.getTransaction().commit();
//
//		} catch(PersistenceException e) {
//				e.getMessage();
//				System.out.println(e.toString());
//				result = false;
//		}
//		finally {
//			entitymanager.close();
//			entitymanagerfactory.close();
//		}		
//		return result;
//	}
}
