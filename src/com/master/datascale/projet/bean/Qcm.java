package com.master.datascale.projet.bean;

/**
 * The Class model of the MCQ
 * @author Joy Jedidja
 *
 */
public class Qcm {

	public Qcm() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * The id of an MCQ object
	 */
	private int id;
	
	/**
	 * The name of the MCQ
	 */
	private String name;
	/**
	 * The description of the MCQ
	 */
	private String description;

	/**
	 * Constructor using fields
	 * @param name The name of the MCQ
	 * @param description The description of the MCQ
	 */
	public Qcm(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	/***
	 * Return the current name of the MCQ
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Modify the value of the MCQ name
	 * @param name The new value of the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return the description of the MCQ
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Modify the value of the MCQ description
	 * @param description the new value of the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Return the value of the id of the current object
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modify the value of the id of the current object
	 * @param id the new value of the id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "Qcm [id="+id+" name=" + name + ", description=" + description + "]";
	}

	
	
	

}
