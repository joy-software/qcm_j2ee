package com.master.datascale.projet.bean;

/**
 * 
 * @author hp
 *
 */
public class Teacher extends User {

	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The title of the course this teacher is teaching.
	 */
	private String courseTitle;
	
	public Teacher(String firstname, String surname) {
		super(firstname, surname);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Return the title of the course teach by the current teacher
	 * @return
	 */
	public String getCourseTitle() {
		return courseTitle;
	}

	/**
	 * Modify the value of the title of the course teach by the current teacher
	 * @param courseTitle the new value of the course title
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

}
