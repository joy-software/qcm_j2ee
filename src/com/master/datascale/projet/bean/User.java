package com.master.datascale.projet.bean;

/**
 * The user class
 * @author Joy Jedidja
 *
 */
public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * The first name of the User
	 */
	public String firstname;
	/**
	 * The last name of the User
	 */
	public String surname;
	
	/**
	 * Constructor using fields
	 * @param firstname the first name of the user
	 * @param surname the last name of the user
	 */
	public User(String firstname, String surname) {
		super();
		this.firstname = firstname;
		this.surname = surname;
	}
	
	/**
	 * Get the first name of the user
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Modify the name of the user
	 * @param firstname the new value of the first name
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Get the last name of the user
	 * @return
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Modify the last name of the user
	 * @param surname the new value of the last name
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", surname=" + surname + "]";
	}
	
	

}
