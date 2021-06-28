package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			String sql = "SELECT * FROM courses INNER JOIN registration ON registration.course_id = courses.course_id AND registration.student_id = VALUES(?) \r\n;";

		} catch (SQLException r) {
			System.out.println("schedule failed!");
			r.printStackTrace();
		}
	}
}
