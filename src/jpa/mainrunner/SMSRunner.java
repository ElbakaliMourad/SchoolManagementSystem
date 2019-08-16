package jpa.mainrunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

	public static void main(String[] args) {
		
		int choice = 0;

		do {
			menu();
			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Enter your Email: ");
				scanner = new Scanner(System.in);
				String email = scanner.nextLine();
				
				System.out.println("Enter Your Password: ");
				scanner = new Scanner(System.in);
				String pass = scanner.nextLine();
				
				Student student = new Student(email, null, pass, null);
				if (validateStudent(student)) {
					System.out.println("Enter Course id: ");
					scanner = new Scanner(System.in);
					int cid = scanner.nextInt();
//					List <Course> crs = new ArrayList<Course>();
//					crs.add(new Course(cid, null, null));
//					
//					student = new Student(email, null, null, crs);
					registerStudentToCourse(email, cid);
				}
				break;
				
			case 2:
				showAllStudents();
				break;
				
			case 3:
				System.out.println("Enter student email: ");
				scanner = new Scanner(System.in);
				email = scanner.nextLine();
				student = new Student(email, null, null, null);
				showStudentByEmail(student);
				break;
				
			case 4:
				showAllCourses();
				break;
				
			case 5:
				System.out.println("\nThanks for using School Managment System Application.\n...exiting program");
				System.exit(0);
				break;

			default: 
				System.out.println("Invalid input. Please try again!\n");
				continue;
			}
		} while (choice != 5);
	}

	private static void registerStudentToCourse(String email, int cid) {
		StudentService studentService = new StudentService();
		boolean result = studentService.registerStudentToCourse(email, cid);
		if (result) {
			System.out.println("Course added: " + cid);
		} else {
			System.out.println("Course Not added: " + cid);
		}		
	}
	

//	private static void registerStudentToCourse(Student student) {
//		StudentService studentService = new StudentService();
//		boolean result = studentService.registerStudentToCourse(student);
//		if (result) {
//			System.out.println("Course added: " + student.getsCourses());
//		} else {
//			System.out.println("Course Not added: " + student.getsCourses());
//		}
//}

	private static void showStudentCourses(Student student) {
		StudentService studentService = new StudentService();
		List<Student> studentList = studentService.getStudentCourses(student);
		System.out.println("Student Found!: ");
		for (Student e : studentList) {
			System.out.println(e.toString());
		}
	}

	private static void menu() {
		System.out.print("\n\n\t\t*** School Managment System App. ***"
				+ "\n\nAre you a(n)" 
				+ "\n1. Student"
				+ "\n2. Show all students"
				+ "\n3. Show student by email"
				+ "\n4. Show all courses"
				+ "\n5. quit"
				+ "\nPlease enter your choice: ");
	}

	private static boolean validateStudent(Student student) {
		boolean result = false;
		StudentService studentService = new StudentService();
		Student foundStudent = studentService.validateStudent(student);
		if (foundStudent == null) {
			System.out.println("Student NOT FOUND, email: " + student.getsEmail());		
		} else {
			System.out.println("My Classes: ");
			System.out.println(foundStudent.getsCourses().toString());
			return true;
		}
		return result;
	}	
	
	private static void showStudentByEmail(Student student) {
		StudentService studentService = new StudentService();
		Student foundStudent = studentService.getStudentByEmail(student);
		System.out.println();
		if (foundStudent == null) {
			System.out.println("Student NOT FOUND, email: " + student.getsEmail());			
		} else {
			System.out.println("Student found!! ");
			System.out.printf("\n%-30s%-30s","Email","Student Name\n"
			         + "-------------------------------------------------\n");
			System.out.println(foundStudent.toString());
		}	
	}

	private static void showAllStudents() {
		StudentService studentService = new StudentService();
		List<Student> studentsList = new ArrayList<>();
		studentsList = studentService.getAllStudents();
		System.out.printf("\n%-30s%-30s","Email","Student Name\n"
				         + "-------------------------------------------------\n");
		for (Student e : studentsList) {
			System.out.println(e.toString());
		}
		System.out.println();
	}

	private static void showAllCourses() {
		CourseService courseService = new CourseService();
		List<Course> coursesList = new ArrayList<>();
		coursesList = courseService.getAllCourses();
		System.out.printf("\n%-4s%-30s%-30s","Id","Course Name","Instructor Name\n"
		         + "---------------------------------------------------\n");
		for (Course e : coursesList) {
			System.out.println(e.toString());
		}
		System.out.println();
	}
}
