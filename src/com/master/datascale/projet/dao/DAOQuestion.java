package com.master.datascale.projet.dao;

import java.util.List;

import com.master.datascale.projet.bean.Question;

public class DAOQuestion extends DAOGeneric<Question, Integer> {

	@Override
	public List<Question> getAll() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createQuery("from question").list() ;
		
	}

}
