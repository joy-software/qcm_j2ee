package com.master.datascale.projet.dao.impl;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.master.datascale.projet.bean.Teacher;
import com.master.datascale.projet.bean.User;
import com.master.datascale.projet.dao.IDAOTeacher;

public class DAOTeacher extends HibernateDaoSupport implements IDAOTeacher{
	
	@Override
	public void save(Teacher t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(Teacher t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void deleteById(Integer i) {
		delete(findById(i));	
	}

	@Override
	public void update(Teacher t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public Teacher findById(Integer i) {
		return (Teacher)getHibernateTemplate().get(Teacher.class, i);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getAll() {
		return (List<Teacher>)getHibernateTemplate().find("from Teacher");
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

	@SuppressWarnings("unchecked")
	@Override
	public boolean isValidated(int id) {
		// TODO Auto-generated method stub
		Boolean result = false;
		
		String query = "from Teacher where user_id = ?";
        Object[] queryParam = {id};
		List<Teacher> Users = (List<Teacher>)getHibernateTemplate().
				find(query,queryParam);
		
		if(Users.size()  > 0)
		{
			result = Users.get(0).isActivated();
		}
		
		return result;
	}
}
