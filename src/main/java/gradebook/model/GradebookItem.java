package main.java.gradebook.model;

import main.java.gradebook.model.*;



public class GradebookItem{

	private String name;
	private double score;
	private GradebookCategory category;

// BEGIN CONSTRUCTERS
	public GradebookItem(String name){
		this.name=name;
	}
	public GradebookItem(double score){
		this.score=score;
	}
	public GradebookItem(String name, double score){
		this.name=name;
		this.score=score;
	}
	public GradebookItem(String name, GradebookCategory category){
		this.name=name;
		this.category=category;
	}
	public GradebookItem(double score, GradebookCategory category){
		this.score=score;
		this.category=category;
	}
	public GradebookItem(String name, double score, GradebookCategory category){
		this.name=name;
		this.score=score;
		this.category=category;
	}
	public GradebookItem(GradebookCategory category){
		this.category=category;
	}
//	END CONSTRUCTOR


	public void setName(String name){
		this.name=name;
	}
	public void setScore(double score){
		this.score=score;
	}
	public void setCategory(GradebookCategory category){
		this.category=category;
	}
	public String getName(){
		if(name==null) return "Unnamed";
		else return name;
	}
	public double getScore(){
		return score;
	}
	public GradebookCategory getCategory(){
		return category;
	}

}