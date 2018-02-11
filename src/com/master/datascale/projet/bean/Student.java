package com.master.datascale.projet.bean;

public class Student extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String numStudent;
	/**
	 * Return the number of the Student
	 * @return 
	 */
	public String getnumStudent() {
		return numStudent;
	}
	
	/**
	 * 
	 * @param The new value of the number Student
	 */
	public void setnumStudent(String numStudent) {
		this.numStudent = numStudent;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Student(int id, String firstname, String surname,String sex,String login,String password,int type) {
		super(id, firstname, surname,sex,login,password,type); //
		// TODO Auto-generated constructor stub
	}

	public Student(int id,String numStudent,String firstname, String surname,String sex,String login,String password,int type) {
		super(id, firstname, surname,sex,login,password,type); 
		this.numStudent = numStudent;
		// TODO Auto-generated constructor stub
	}
	
	public Student(String firstname, String surname,String sex,String login,String password,String numStudent) {
		super(firstname, surname,sex,login,password); 
		this.numStudent = numStudent;
		// TODO Auto-generated constructor stub
	}

	
	public String toString() {
		return "Student [numStudent=" + numStudent + ", id=" + getId() + ", firstname=" + getFirstname() + ", surname="
				+ getSurname() + ", login= "+getLogin() + "]";
	}
	
}
