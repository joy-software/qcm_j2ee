package com.master.datascale.projet.dao.impl;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.master.datascale.projet.bean.Question;
import com.master.datascale.projet.dao.IDAOQuestion;

/**
 * 
 * @author Joy Jedidja
 *
 */
public class DAOQuestion extends HibernateDaoSupport implements IDAOQuestion {

	@Override
	public void save(Question t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(Question t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void deleteById(Integer i) {
		delete(findById(i));	
	}

	@Override
	public void update(Question t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public Question findById(Integer i) {
		return (Question)getHibernateTemplate().get(Question.class, i);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getAll() {
		return (List<Question>)getHibernateTemplate().find("from Question");
	}
	

}
