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

}
