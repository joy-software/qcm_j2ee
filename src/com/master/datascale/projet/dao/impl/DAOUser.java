package com.master.datascale.projet.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.master.datascale.projet.bean.User;
import com.master.datascale.projet.dao.IDAOUser;

public class DAOUser extends HibernateDaoSupport implements IDAOUser {

	@Override
	public void save(User t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(User t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void deleteById(Integer i) {
		delete(findById(i));	
	}

	@Override
	public void update(User t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public User findById(Integer i) {
		return (User)getHibernateTemplate().get(User.class, i);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		return (List<User>)getHibernateTemplate().find("from User");
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkCredentials(String login, String password) {
		
		Boolean result = false;
		
		String query = "from User where login = ? and password = ?";
        Object[] queryParam = {login, password};
		List<User> Users = (List<User>)getHibernateTemplate().
				find(query,queryParam);
		
		if(Users.size()  > 0)
		{
			System.out.println("C'est bon");
			
			result = true;
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String login, String password) {
		// TODO Auto-generated method stub
		String query = "from User where login = ? and password = ?";
        Object[] queryParam = {login, password};
		List<User> Users = (List<User>)getHibernateTemplate().
				find(query,queryParam);
		
		return Users.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validateLogin(String login) {
		Boolean result = true;
		
		String query = "from User where login = ?";
        Object[] queryParam = {login};
		List<User> Users = (List<User>)getHibernateTemplate().
				find(query,queryParam);
		
		if(Users.size()  > 0)
		{
			
			result = false;
		}
		
		return result;
	}

}
