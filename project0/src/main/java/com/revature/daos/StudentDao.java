package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Student;
import com.revature.utils.ConnectionUtil;

public class StudentDao implements StudentDaoInterface {

	@Override
	public List<Student> getStudents() { // this is SELECT functionality

		try (Connection conn = ConnectionUtil.getConnection()) { // try to establish a DB connection, so we can run a
																	// query

			// initialize an empty ResultSet that will store the results of our query
			ResultSet rs = null; // we need this for select statements, so that the returned data can get stored

			// write the query, assign it to a String variable
			String sql = "SELECT * FROM uni.students;";

			// creating an object to send the query to our DB using our Connection object's
			// createStatement() method
			Statement s = conn.createStatement();

			// execute the query (sql) using our Statement object (s), put it in our
			// ResultSet (rs)
			rs = s.executeQuery(sql); // again, the ResultSet just holds all the data we get back from the select
										// statement

			List<Student> studentList = new ArrayList<>(); // create a List that will be populated with the returned
															// students

			while (rs.next()) { // while there are results left in the ResultSet (rs)

				// Create a new Student Object from each returned record
				// This is the Student Class's all args constructor
				// And we're filling it with each column of the Student record
				Student student = new Student(rs.getInt("student_id"), rs.getString("f_name"), rs.getString("l_name"));

				// add the newly created Student object into the ArrayList of Students
				studentList.add(student);

			}

			return studentList; // Finally, if successful, return the List of Students

		} catch (SQLException e) { // if something goes wrong accessing our data, it will get caught
			System.out.println("Something went wrong when trying to access your DB");
			e.printStackTrace();
		}

		return null; // java will yell if we don't have this, cause the try isn't guaranteed to
						// succeed
	}

	@Override
	public void addStudent(Student stu) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO students (f_name, l_name) VALUES (?,?);";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, stu.getF_name());
			ps.setString(2, stu.getL_name());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Add student failed!");
			e.printStackTrace();
		}
	}
}