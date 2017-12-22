package com.master.datascale.projet.dao;

import java.util.List;

import com.master.datascale.projet.bean.Student;

public class DAOStudent extends DAOGeneric<Student, Integer> {

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createQuery("from student").list() ;
	}

}
