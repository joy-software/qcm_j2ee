package com.master.datascale.projet.dao.impl;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.master.datascale.projet.bean.Answer;
import com.master.datascale.projet.bean.Question;
import com.master.datascale.projet.dao.IDAOAnswer;
import com.master.datascale.projet.dao.IDAOQuestion;

/**
 * 
 * @author Joy Jedidja
 *
 */
public class DAOAnswer extends HibernateDaoSupport implements IDAOAnswer{

	

	@Override
	public void deleteById(Integer i) {
		delete(findById(i));	
	}

	@Override
	public void save(Answer t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(Answer t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(Answer t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public Answer findById(Integer i) {
		return (Answer)getHibernateTemplate().get(Answer.class, i);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> getAll() {
		return (List<Answer>)getHibernateTemplate().find("from Answer");
	}
	

}
