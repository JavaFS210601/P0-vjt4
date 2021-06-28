package com.revature.models;

public class Reg {
	private int registration_id;
	private int course_id;
	private int student_id;

	public Reg() {
		super();
	}

	public Reg(int registration_id, int course_id, int student_id) {
		super();
		this.registration_id = registration_id;
		this.course_id = course_id;
		this.student_id = student_id;
	}

	public Reg(int course_id, int student_id) {
		super();
		this.course_id = course_id;
		this.student_id = student_id;
	}

	@Override
	public String toString() {
		return "Reg [registration_id=" + registration_id + ", course_id=" + course_id + ", student_id=" + student_id
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + course_id;
		result = prime * result + registration_id;
		result = prime * result + student_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reg other = (Reg) obj;
		if (course_id != other.course_id)
			return false;
		if (registration_id != other.registration_id)
			return false;
		if (student_id != other.student_id)
			return false;
		return true;
	}

	public int getRegistration_id() {
		return registration_id;
	}

	public void setRegistration_id(int registration_id) {
		this.registration_id = registration_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

}
