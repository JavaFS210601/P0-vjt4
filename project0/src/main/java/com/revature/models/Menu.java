package com.revature.models;

import java.util.List;
import java.util.Scanner;

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
			System.out.println("students -> show all students");
			System.out.println("register -> register for a course");
			System.out.println("schedule -> show a student's schedule");
			System.out.println("exit -> exit the application");

			// parse the user input after they choose a menu option, and move to the next
			// line
			String input = scan.nextLine().toLowerCase();

			switch (input) {

			case "students": {
				System.out.println("Gathering all students...");

				List<Student> students = sd.getStudents();

				for (Student s : students) {
					System.out.println(s);
				}

				break;
			}

			case "register": {
				List<Student> students = sd.getStudents();

				for (Student s : students) {
					System.out.println(s);
				}
				System.out.println("-----------------------------------------------------");

				System.out.println("Enter the ID of the student who's registering");
				int idInput = scan.nextInt(); // the user enters the ID of the student to scan.nextline
				scan.nextLine();

				List<Course> courses = cd.getCourses();
				for (Course c : courses) {
					System.out.println(c);
				}
				System.out.println("-----------------------------------------------------");
				String currentStudent = Integer.toString(idInput);
				System.out.println("Enter the ID of the Course you'd like to register for student " + currentStudent);
				int courseInput = scan.nextInt();
				scan.nextLine();

				rd.register(courseInput, idInput);
				break;
			}
			case "exit": {
				System.out.println("byeeee");
				displayMenu = false;
				break;
			}

			default: {
				System.out.println("Didn't catch that... try again"); // in case user input doesn't match any cases
				break;
			}

			}
		}
	}
}
