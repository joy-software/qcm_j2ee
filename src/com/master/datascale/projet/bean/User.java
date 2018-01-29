package com.master.datascale.projet.bean;

import org.apache.struts.action.ActionForm;

/**
 * The user class
 * @author Joy Jedidja
 *
 */
public class User extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 * The login of the User
	 */
	public String login;
	
	/**
	 * The password of the User
	 */
	public String password;

	/**
	 * Constructor using fields
	 * @param firstname the first name of the user
	 * @param surname the last name of the user
	 * @param id the id of the user
	 */
	public User(int id, String firstname, String surname,String login, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
		this.login = login;
		this.password = password;
	}
	/*/
	
	/**
	 * Constructor using fields
	 * @param login the first name of the user
	 * @param password the last name of the user
	 */
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
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
	/**
	 * Get the Login of the User
	 * @return
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Modify the login of the user
	 * @param login The new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Return the password of the User
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Modify the password of the User
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", surname="
				+ surname + ", login= "+login + "]";
	}





}
