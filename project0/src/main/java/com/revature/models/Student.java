package com.revature.models;

public class Student {
	private int student_id;
	private String f_name;
	private String l_name;

	public Student() {
		super();
	}

	public Student(int student_id, String f_name, String l_name) {
		super();
		this.student_id = student_id;
		this.f_name = f_name;
		this.l_name = l_name;
	}

	public Student(String f_name, String l_name) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", f_name=" + f_name + ", l_name=" + l_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
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
		Student other = (Student) obj;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (l_name == null) {
			if (other.l_name != null)
				return false;
		} else if (!l_name.equals(other.l_name))
			return false;
		if (student_id != other.student_id)
			return false;
		return true;
	}

	public int getStudent_id() {
		return student_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

}
