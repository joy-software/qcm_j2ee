package com.master.datascale.projet.bean;

public class Question {

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
	
	

}
