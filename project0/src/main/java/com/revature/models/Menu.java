package com.revature.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.CourseDao;
import com.revature.daos.RegDao;
import com.revature.daos.StudentDao;

public class Menu {
	StudentDao sd = new StudentDao();
	CourseDao cd = new CourseDao();
	RegDao rd = new RegDao();

	public void display() {

		boolean displayMenu = true; // this toggles whether the menu continues after user input
		Scanner scan = new Scanner(System.in); // Scanner object to parse user input
		final Logger log = LogManager.getLogger(Menu.class);

		// greeting
		System.out.println("*====================================================*");
		System.out.println("Class Registration");
		System.out.println("*====================================================*");

		// display the menu options as long as displayMenu is true
		while (displayMenu) {

			System.out.println("----------------");
			System.out.println("CHOOSE AN OPTION");
			System.out.println("----------------");

			// menu options
			System.out.println("students | show all students");
			System.out.println("register | register for a course");
			System.out.println("schedule | show a student's schedule");
			System.out.println("add      | add a a student");
			System.out.println("exit     | exit the application");

			// parse the user input after they choose a menu option, and move to the next
			// line
			String input = scan.nextLine().toLowerCase();

			switch (input) {

			case "students": {
				log.info("User selected students");
				System.out.println("Gathering all students...");

				List<Student> students = sd.getStudents();

				for (Student s : students) {
					// System.out.println(s.getStudent_id() + "");
					System.out.println(s.getStudent_id() + ") " + s.getF_name() + " " + s.getL_name());
				}

				break;
			}

			case "register": {
				List<Student> students = sd.getStudents();

				for (Student s : students) {
					System.out.println(s.getStudent_id() + ") " + s.getF_name() + " " + s.getL_name());
				}
				System.out.println("-----------------------------------------------------");

				System.out.println("Enter the ID of the student who's registering");
				int idInput = scan.nextInt(); // the user enters the ID of the student to scan.nextline
				scan.nextLine();
				log.warn("Student registered for a class!");

				List<Course> courses = cd.getCourses();
				for (Course c : courses) {
					System.out.println(
							c.getCourse_id() + ") " + c.getCourse_title() + " " + c.getCourse_credits() + " Credits");
				}
				System.out.println("-----------------------------------------------------");
				String currentStudent = Integer.toString(idInput);
				System.out.println("Enter the ID of the Course you'd like to register for student " + currentStudent);
				int courseInput = scan.nextInt();
				scan.nextLine();

				rd.register(courseInput, idInput);
				break;
			}
			case "schedule": {
				log.info("schedule printed");
				List<Student> students = sd.getStudents();

				for (Student s : students) {
					System.out.println(s.getStudent_id() + ") " + s.getF_name() + " " + s.getL_name());
				}
				System.out.println("-----------------------------------------------------");

				System.out.println("Enter the ID for their Schedule");
				int idInput = scan.nextInt();
				scan.nextLine();

				rd.schedule(idInput);

				break;
			}
			case "add": {
				log.info("User attempted to add student to database");
				System.out.println("Enter Student First Name:");
				String f_name = scan.nextLine();
				System.out.println("Enter Student Last Name:");
				String l_name = scan.nextLine();

				// give all this info we creat a new Employee object
				Student newStudent = new Student(f_name, l_name);

				sd.addStudent(newStudent);

				break;
			}
			case "exit": {
				System.out.println("byeeee");
				displayMenu = false;
				break;
			}

			default: {
				System.out.println("Nah Nah Nah"); // in case user input doesn't match any cases
				break;
			}

			}
		}
	}
}
