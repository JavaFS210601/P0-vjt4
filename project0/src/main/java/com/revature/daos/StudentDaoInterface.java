package com.revature.daos;

import java.util.List;

import com.revature.models.Student;

//Remember, Interfaces provide methods with no body (abstract methods) meant to be implemented in another class
//Basically just a good way to lay out the functionality we want to have
public interface StudentDaoInterface {

	public List<Student> getStudents(); // return a List of all employees

	public void addStudent(Student stu);

}