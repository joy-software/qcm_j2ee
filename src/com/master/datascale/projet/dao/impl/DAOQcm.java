package com.master.datascale.projet.dao.impl;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.master.datascale.projet.bean.Qcm;
import com.master.datascale.projet.dao.IDAOQcm;

public class DAOQcm  extends HibernateDaoSupport implements IDAOQcm {

	@Override
	public void save(Qcm t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(Qcm t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void deleteById(Integer i) {
		delete(findById(i));	
	}

	@Override
	public void update(Qcm t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public Qcm findById(Integer i) {
		return (Qcm)getHibernateTemplate().get(Qcm.class, i);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Qcm> getAll() {
		return (List<Qcm>)getHibernateTemplate().find("from Qcm");
	}


	

	
}
