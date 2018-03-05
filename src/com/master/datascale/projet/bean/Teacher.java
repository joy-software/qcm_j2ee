package com.master.datascale.projet.bean;

import java.util.HashSet;
import java.util.Set;

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
	/**
	 * Check if this teacher has been actived by the administrator
	 */
	private boolean activated;

	private Set<Qcm> Qcms = new HashSet<Qcm>();

	public Teacher(int id, String firstname, String surname,String sex,String login,String password,String courseTitle,int type) {
		super(id, firstname, surname,sex,login,password,type);
		this.courseTitle = courseTitle;
		this.activated = false;
		// TODO Auto-generated constructor stub
	}
	
	public Teacher(int id, String firstname, String surname,String sex,String login,String password,String courseTitle,int type,boolean activated) {
		super(id, firstname, surname,sex,login,password,type);
		this.courseTitle = courseTitle;
		this.activated = activated;
		// TODO Auto-generated constructor stub
	}

	public Teacher(String firstname, String surname,String sex,String login,String password) {
		super(firstname, surname,sex,login,password);
		this.activated = false;
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
		return "Teacher [courseTitle=" + courseTitle + ",id=" + getId() + ", firstname=" + getFirstname() + ", surname="
				+ getSurname() + ", login= "+getLogin() + "]";
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Set<Qcm> getQcms() {
		return Qcms;
	}

	public void setQcms(Set<Qcm> qcms) {
		
		for(Qcm qcm : qcms)
		{
			qcm.setTeacher(this);
		}
		Qcms = qcms;
	}
	
	
	
	

}
