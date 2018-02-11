package com.master.datascale.projet.dao;

import com.master.datascale.projet.bean.User;

public interface IDAOUser extends DAOInterface<User, Integer> {
	
	/**
	 * Check if the credential send are inside the database
	 * @param login the login of the User
	 * @param password The password of the User
	 * @return
	 */
	public boolean checkCredentials(String login, String password);
	
	/**
	 * geta user from the database
	 * @param login the login of the User
	 * @param password The password of the User
	 * @return
	 */
	public User getUser(String login, String password);
	
	/**
	 * Check that the login of this user is unique
	 * @param login the login of the new User
	 * @return
	 */
	public boolean validateLogin(String login);

}
