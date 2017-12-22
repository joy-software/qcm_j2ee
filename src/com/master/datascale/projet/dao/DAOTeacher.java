package com.master.datascale.projet.dao;

import java.util.List;

import com.master.datascale.projet.bean.Teacher;

public class DAOTeacher extends DAOGeneric<Teacher, Integer> {

	@Override
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createQuery("from teacher").list() ;
	}

}
