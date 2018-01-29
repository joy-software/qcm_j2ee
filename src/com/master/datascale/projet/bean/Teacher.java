package com.master.datascale.projet.bean;

/**
 * 
 * The teacher Class model
 * @author Joy Jedidja
 *
 */
public class Teacher extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The title of the course this teacher is teaching.
	 */
	private String courseTitle;

	public Teacher(int id, String firstname, String surname,String login,String password,String courseTitle) {
		super(id, firstname, surname,login,password);
		this.courseTitle = courseTitle;
		// TODO Auto-generated constructor stub
	}

	public Teacher(int id, String firstname, String surname,String login,String password) {
		super(id, firstname, surname,login,password);
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

	
	public String toString() {
		return "Teacher [courseTitle=" + courseTitle + ", firstname=" + firstname + ", surname=" + surname + "]";
	}
	
	
	
	

}
