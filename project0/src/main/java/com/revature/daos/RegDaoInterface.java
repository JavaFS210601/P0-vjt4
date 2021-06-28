package com.revature.daos;

public interface RegDaoInterface {

	public void register(int courseId, int studentId); // change an employee's role_id given their employee_id

	public void drop(int courseId, int studentId);

	public void schedule(int studentId);

}