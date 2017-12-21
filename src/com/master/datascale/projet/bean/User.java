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
	 * The id of the user
	 */
	public int id;

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
	 * @param id the id of the user
	 */
	public User(int id, String firstname, String surname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
	}

	/**
	 * 
	 * @return Return the id of the user
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id the new value of the id user
	 */
	public void setId(int id) {
		this.id = id;
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


	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", surname="
				+ surname + "]";
	}





}
