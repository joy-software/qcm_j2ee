package com.master.datascale.projet.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import com.master.datascale.projet.bean.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * 
 * @author Joy Jedidja
 * 
 *@param <T> The type of Object that must handle the class that extends this one
 * @param <Id> The type of Object  that has the <T> Class as Id.
 */
public abstract class DAOGeneric<T, Id> implements DAOInterface<T, Serializable> {

	
	public DAOGeneric() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * The SessionFactory of Hibernate
	 */
	private SessionFactory sessionFactory; 
	
	@Override
	public void save(T t) {
			
		Transaction tx = null;
		
		Session session = getSessionFactory().getCurrentSession();
		
		try {
			
			tx = session.beginTransaction();
			
			session.save(t);
			
			tx.commit();
		} catch (HibernateException e) {
			
			tx.rollback();
		}
		
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		
		Session session = getSessionFactory().getCurrentSession();
		
		try {
			
			tx = session.beginTransaction();
			
			session.delete(t);
			
			tx.commit();
		} catch (HibernateException e) {
			
			tx.rollback();
		}
	}

	@Override
	public void deleteById(Serializable i) {
		delete(findById(i));
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		
		Session session = getSessionFactory().getCurrentSession();
		
		try {
			
			tx = session.beginTransaction();
			
			session.update(t);
			
			tx.commit();
		} catch (HibernateException e) {
			
			tx.rollback();
		}
	}

	@Override
	public T findById(Serializable i) {
		// TODO Auto-generated method stub
		T result = null;
		Transaction tx = null;
		
		Session session = getSessionFactory().getCurrentSession();
		
		try {
			
			tx = session.beginTransaction();
			
			result = (T) session.get(User.class, i);
			
			tx.commit();
		} catch (HibernateException e) {
			
			tx.rollback();
		}
		
		return result;
	}

	/**
	 * Get The Session Factory
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Modify the session factory
	 * @param sessionFactory The new Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
