package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Course;
import com.revature.utils.ConnectionUtil;

public class CourseDao implements CourseDaoInterface {

	@Override
	public List<Course> getCourses() { // this is SELECT functionality

		try (Connection conn = ConnectionUtil.getConnection()) { // try to establish a DB connection, so we can run a
																	// query

			// initialize an empty ResultSet that will store the results of our query
			ResultSet rs = null; // we need this for select statements, so that the returned data can get stored

			// write the query, assign it to a String variable
			String sql = "SELECT * FROM uni.courses;";

			// creating an object to send the query to our DB using our Connection object's
			// createStatement() method
			Statement s = conn.createStatement();

			// execute the query (sql) using our Statement object (s), put it in our
			// ResultSet (rs)
			rs = s.executeQuery(sql); // again, the ResultSet just holds all the data we get back from the select
										// statement

			List<Course> courseList = new ArrayList<>(); // create a List that will be populated with the returned
															// courses

			while (rs.next()) { // while there are results left in the ResultSet (rs)

				// Create a new Course Object from each returned record
				// This is the Course Class's all args constructor
				// And we're filling it with each column of the Course record
				Course course = new Course(rs.getInt("course_id"), rs.getString("course_title"),
						rs.getInt("course_credits"));

				// add the newly created Course object into the ArrayList of Courses
				courseList.add(course);

			}

			return courseList; // Finally, if successful, return the List of Courses

		} catch (SQLException e) { // if something goes wrong accessing our data, it will get caught
			System.out.println("Something went wrong when trying to access your DB");
			e.printStackTrace();
		}

		return null; // java will yell if we don't have this, cause the try isn't guaranteed to
						// succeed
	}
}