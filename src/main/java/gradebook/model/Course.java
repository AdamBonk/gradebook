package main.java.gradebook.model;

import main.java.gradebook.model.*;


public class Course{
	/*
	Subjects should be formatted all caps
	and in their short form e.g. "CS"
	*/
	private String subject;
	private String name;
	private int courseNumber;
	protected String description;
	protected GradebookStorage preRequesites;

//	BEGIN CONSTRUCTORS
	public Course(String subject, String name, int courseNumber){
		this.subject=subject;
		this.name=name;
		this.courseNumber=courseNumber;
	}
	public Course(String subject, String name, int courseNumber, GradebookStorage preRequesites){
		this.subject=subject;
		this.name=name;
		this.courseNumber=courseNumber;
		this.preRequesites=preRequesites;
	}
	public Course(String subject, String name, int courseNumber, GradebookStorage preRequesites, String description){
		this.subject=subject;
		this.name=name;
		this.courseNumber=courseNumber;
		this.preRequesites=preRequesites;
		this.description=description;
	}
	public Course(Course otherCourse){
		subject=otherCourse.getSubject();
		name=otherCourse.getName();
		courseNumber=otherCourse.getCourseNumber();
		description=otherCourse.getDescription();
		preRequesites=otherCourse.getPreRequisites();
	}
//	END CONSTRUCTORS


	public String getSubject(){
		return subject;
	}
	public String getName(){
		return name;
	}
	public int getCourseNumber(){
		return courseNumber;
	}
	public String getDescription(){
		return description;
	}
	public GradebookStorage getPreRequisites(){
		return preRequesites;
	}
}