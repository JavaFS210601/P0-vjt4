package com.revature.daos;

import java.util.List;

import com.revature.models.Course;

//Remember, Interfaces provide methods with no body (abstract methods) meant to be implemented in another class
//Basically just a good way to lay out the functionality we want to have
public interface CourseDaoInterface {

	public List<Course> getCourses(); // return a List of all employees
}