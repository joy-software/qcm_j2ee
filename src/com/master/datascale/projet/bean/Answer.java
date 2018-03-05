package com.master.datascale.projet.bean;

import org.apache.struts.action.ActionForm;

public class Answer extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The value of the answer which the student had chosen 
	 */

	private String value;
	
	private Question question;
	
	/**
	 * The id of the answer that student had chosen
	 */
	private int id;
	
	/**
	 * return the value selected by the student
	 * @return 
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * 
	 * @param value the new value given by the student
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Return the id of the answer chosen by the student
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id The new value of the id 
	 */
	public void setId(int id) {
		this.id = id;
	}

	public Answer(String value, int id) {
		super();
		this.value = value;
		this.id = id;
	}
	
	public Answer(String value) {
		super();
		this.value = value;
	}
	
	
	public Answer(String value, Question question) {
		super();
		this.value = value;
		this.question = question;
	}

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [value=" + value + ", id=" + id + "]";
	}
	
	
	
	
}
