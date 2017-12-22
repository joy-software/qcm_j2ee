package com.master.datascale.projet.dao;

import java.util.List;

import com.master.datascale.projet.bean.Qcm;

public class DAOQcm extends DAOGeneric<Qcm, Integer> {

	@Override
	public List<Qcm> getAll() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createQuery("from qcm").list() ;
	}

}
