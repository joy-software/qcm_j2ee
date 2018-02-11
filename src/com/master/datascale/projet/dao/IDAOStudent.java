package com.master.datascale.projet.dao;

import com.master.datascale.projet.bean.Student;

public interface IDAOStudent extends DAOInterface<Student, Integer> {
	
	/**
	 * Check that the login of this user is unique
	 * @param login the login of the new User
	 * @return
	 */
	public boolean validateLogin(String login);


}
