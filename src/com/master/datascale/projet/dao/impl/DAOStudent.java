package com.master.datascale.projet.dao.impl;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.master.datascale.projet.bean.Student;
import com.master.datascale.projet.bean.User;
import com.master.datascale.projet.dao.IDAOStudent;

/**
 * 
 * @author Joy Jedidja
 *
 */
public class DAOStudent extends HibernateDaoSupport implements IDAOStudent{

	@Override
	public void save(Student t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(Student t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void deleteById(Integer i) {
		delete(findById(i));	
	}

	@Override
	public void update(Student t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public Student findById(Integer i) {
		return (Student)getHibernateTemplate().get(Student.class, i);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAll() {
		return (List<Student>)getHibernateTemplate().find("from Student");
	}
	
	@Override
	public boolean validateLogin(String login) {
		Boolean result = true;
		
		String query = "from User where login = ?";
        Object[] queryParam = {login};
		@SuppressWarnings("unchecked")
		List<User> Users = (List<User>)getHibernateTemplate().
				find(query,queryParam);
		
		if(Users.size()  > 0)
		{
			
			result = false;
		}
		
		return result;
	}
}
