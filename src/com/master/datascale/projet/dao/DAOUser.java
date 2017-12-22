package com.master.datascale.projet.dao;

import java.util.List;

import com.master.datascale.projet.bean.User;

public class DAOUser extends DAOGeneric<User, Integer> {

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createQuery("from users").list() ;
	}

}
