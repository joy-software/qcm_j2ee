package com.master.datascale.projet.bean;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts.action.ActionForm;

/**
 * The Class model of the MCQ
 * @author Joy Jedidja
 *
 */
public class Qcm extends ActionForm{

	private static final long serialVersionUID = 1L;

	
	private Set<Student> Students = new HashSet<Student>(0);
	private Set<Question> Questions = new HashSet<Question>(0);
	private Teacher teacher;


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
	 * The difficulty of the MCQ
	 */
	private String difficulty;

	/**
	 * Constructor using fields
	 * @param name The name of the MCQ
	 * @param description The description of the MCQ
	 */
	public Qcm(String name, String description,String difficulty) {
		super();
		this.name = name;
		this.description = description;
		this.difficulty = difficulty;
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

	/**
	 * Get the difficulty of the MCQ
	 * @return
	 */
	public String getDifficulty() {
		return difficulty;
	}

	/**
	 * Modify the difficulty of the MCQ
	 * @param difficulty
	 */
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public Set<Student> getStudents() {
		return Students;
	}

	public void setStudents(Set<Student> students) {
		Students = students;
	}

	public Set<Question> getQuestions() {
		return Questions;
	}

	public void setQuestions(Set<Question> questions) {
		Questions = questions;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
	
	

}
