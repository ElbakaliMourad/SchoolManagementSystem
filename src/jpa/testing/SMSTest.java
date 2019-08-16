package jpa.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jpa.entitymodels.Student;
import jpa.service.StudentService;

public class SMSTest {

	static StudentService testStudentService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testStudentService = new StudentService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetAllStudents() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetStudentByEmail() {

		String input = "aiannitti7@is.gd";
		Student expected = new Student();
		expected.setsEmail("aiannitti7@is.gd");
		assertEquals(input, expected);

		// fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetStudentPassword() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testValidateStudent() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetStudentCourses() {
		fail("Not yet implemented"); // TODO
	}

}
