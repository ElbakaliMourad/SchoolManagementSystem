package jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO {

	@Override
	public List<Course> getAllCourses() {
		
	List<Course> itemsList = new ArrayList<>();		
	EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("SMS");
	EntityManager entitymanager = entitymanagerfactory.createEntityManager();
	
//	Query query = entitymanager.createQuery("SELECT e FROM Course e");
	Query query = entitymanager.createNamedQuery("queryCoursesAll");
	itemsList = query.getResultList();
	
	entitymanager.close();
	entitymanagerfactory.close();
	
	return itemsList;
	}

}
