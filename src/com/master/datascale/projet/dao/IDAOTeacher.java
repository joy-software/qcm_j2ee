package com.master.datascale.projet.dao;

import com.master.datascale.projet.bean.Teacher;

/**
 * 
 * @author Joy Jedidja
 *
 */
public interface IDAOTeacher extends DAOInterface<Teacher, Integer> {
	
	/**
	 * Check that the login of this user is unique
	 * @param login the login of the new User
	 * @return
	 */
	public boolean validateLogin(String login);

	/**
	 * Check if the account of this teacher is already validated
	 * @param id the id of the related user
	 * @return
	 */
	public boolean isValidated(int id);

}
