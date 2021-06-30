package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Course;
import com.revature.utils.ConnectionUtil;

public class RegDao implements RegDaoInterface {

	@Override
	public void register(int courseId, int studentId) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {

			// notice how there are no ResultSet object in methods that don't include select
			// statements...
			// because we aren't returning anything! Only changing stuff in the DB, not
			// getting data from it.

			String sql = "INSERT INTO registration (course_id, student_id) VALUES (?,?);";

			PreparedStatement ps = conn.prepareStatement(sql); // make a PreparedStatement using the SQL String we made

			// adding values to the wildcard parameters based on the user's input
			ps.setInt(1, courseId);
			ps.setInt(2, studentId);

			ps.executeUpdate(); // Run the PreparedStatement now that we've given values to its parameters

			System.out.println("Student " + studentId + " registered for course " + courseId);

		} catch (SQLException r) {
			System.out.println("Registration failed!");
			r.printStackTrace();
		}

	}

	@Override
	public void drop(int courseId, int studentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void schedule(int studentId) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {

			ResultSet rs = null;

			String sql = "SELECT DISTINCT * FROM courses INNER JOIN registration ON registration.course_id = courses.course_id AND registration.student_id = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			// Statement s = conn.createStatement();

			ps.setInt(1, studentId);

			rs = ps.executeQuery();

			// ps.executeUpdate();

			List<Course> courseList = new ArrayList<>();

			while (rs.next()) { // while there are results left in the ResultSet (rs)

				// Create a new Course Object from each returned record
				// This is the Course Class's all args constructor
				// And we're filling it with each column of the Course record
				Course course = new Course(rs.getInt("course_id"), rs.getString("course_title"),
						rs.getInt("course_credits"));

				// add the newly created Course object into the ArrayList of Courses
				courseList.add(course);
				System.out.println("Classes this semester: " + courseList.size());
				// if (rs.next()) {
				// System.out.println("not Registered for any classes!");
				// }

				for (Course c : courseList) {
					System.out.println(c.getCourse_title() + ": " + c.getCourse_credits() + " Credits");
				}
				// System.out.println("course list size: " + courseList.size());
				// if (courseList.size() == 0) {
				// System.out.println("not Registered for any classes!");

			}

		} catch (SQLException r) {
			System.out.println("schedule failed!");
			r.printStackTrace();
		}
	}
}
