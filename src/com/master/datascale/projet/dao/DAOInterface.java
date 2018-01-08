package com.master.datascale.projet.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Joy Jedidja
 *
 * @param <T> The type of Object that must handle the class that extends this one
 * @param <Id> The type of Object  that has the <T> Class as Id.
 */
public interface DAOInterface<T,Id extends Serializable> {

	/**
	 * Save the object send as parameters and return its created Id 
	 * @param t The object to persist
	 * @return 
	 */
	public void save(T t);
	/**
	 * Delete the object send as parameters and return its created Id 
	 * @param t The object to persist
	 * @return
	 */
	public void delete(T t);
	/**
	 * Delete the object send as parameters and return its created Id 
	 * @param Id The Id of the object to delete
	 * @return
	 */
	public void deleteById(Id i);
	/**
	 * Save the object send as parameters
	 * @param t The object to merge
	 * @return
	 */
	public void update(T t);
	/**
	 * Find the object which Id is send as parameters 
	 * @param i The Id of the object to look for
	 * @return
	 */
	public T findById(Id i);
	/**
	 * Get all the stored objects of this class from the database 
	 * @return
	 */
	public List<T> getAll(String query);
}
