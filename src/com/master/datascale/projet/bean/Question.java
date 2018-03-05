package com.master.datascale.projet.bean;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts.action.ActionForm;

public class Question extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Qcm qcm;
	private Set<Answer> Answers = new HashSet<Answer>();
	

	public Question() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * The id of an MCQ object
	 */
	private int id;
	
	/**
	 * the entitled of the question
	 */
	private String entitled;
	
	/**
	 * a list of answer id related to this question separated by '#' symbol 
	 */
	private String goodAnswer;
	
	
	
	/**
	 * Constructor using fields
	 * @param entitled {@link #entitled}
	 */
	public Question(String entitled) {
		super();
		this.entitled = entitled;
	}
	
	/**
	 * Constructor using fields
	 * @param entitled {@link #entitled}
	 */
	public Question(String entitled,Qcm qcm) {
		super();
		this.entitled = entitled;
		this.qcm = qcm;
	}


	
	/**
	 * Constructor using fields
	 * @param entitled {@link #entitled}
	 * @param goodAnswer {@link #goodAnswer}
	 */
	public Question(String entitled, String goodAnswer) {
		super();
		this.entitled = entitled;
		this.goodAnswer = goodAnswer;
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

	/**
	 * Return The {@link #entitled}
	 * @return
	 */
	public String getEntitled() {
		return entitled;
	}

	/**
	 * Modify the value of the {@link #entitled} 
	 * @param entitled the new value of the {@link #entitled}
	 */
	public void setEntitled(String entitled) {
		this.entitled = entitled;
	}

	/**
	 * Get the {@link #goodAnswer} object's related to this question
	 * @return
	 */
	public String getGoodAnswer() {
		return goodAnswer;
	}
	
	/**
	 *Modify the value of the {@link #goodAnswer}
	 * @param goodAnswer the new value of the {@link #goodAnswer}
	 */
	public void setGoodAnswer(String goodAnswer) {
		this.goodAnswer = goodAnswer;
	}

	
	public String toString() {
		return "Question [id=" + id + ", entitled=" + entitled + ", goodAnswer=" + goodAnswer + "]";
	}

	public Qcm getQcm() {
		return qcm;
	}

	public void setQcm(Qcm qcm) {
		this.qcm = qcm;
	}


	public Set<Answer> getAnswers() {
		return Answers;
	}


	public void setAnswers(Set<Answer> answers) {
		for(Answer answer: answers)
		{
			answer.setQuestion(this);
		}
		Answers = answers;
	}
	
	

}
