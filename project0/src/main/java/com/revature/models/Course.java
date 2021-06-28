package com.revature.models;

public class Course {
	private int course_id;
	private String course_title;
	private int course_credits;

	public Course() {
		super();
	}

	public Course(int course_id, String course_title, int course_credits) {
		super();
		this.course_id = course_id;
		this.course_title = course_title;
		this.course_credits = course_credits;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_title=" + course_title + ", course_credits="
				+ course_credits + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + course_credits;
		result = prime * result + course_id;
		result = prime * result + ((course_title == null) ? 0 : course_title.hashCode());
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
		Course other = (Course) obj;
		if (course_credits != other.course_credits)
			return false;
		if (course_id != other.course_id)
			return false;
		if (course_title == null) {
			if (other.course_title != null)
				return false;
		} else if (!course_title.equals(other.course_title))
			return false;
		return true;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_title() {
		return course_title;
	}

	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}

	public int getCourse_credits() {
		return course_credits;
	}

	public void setCourse_credits(int course_credits) {
		this.course_credits = course_credits;
	}

}
