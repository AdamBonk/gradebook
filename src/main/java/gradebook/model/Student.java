package main.java.gradebook.model;

import main.java.gradebook.model.*;

public class Student {

	private String name;
	/*
	According to the flyweight design, we can have
	one student object representing each student, regardless
	of the number of classes in which they are enrolled.
	*/

	private GradebookStorage enrolledClasses;
	private GradebookStorage gradebookCategoriesBySection;
	private GradebookStorage completedClasses;
	/* using the associate method I can associate classes with sections */

//	BEGIN CONSTRUCTORS

	public Student(String name){
		this.name= name;
		enrolledClasses=new GradebookStorage();
	}
	public Student(String name, GradebookStorage completedClasses){
		this.name=name;
		this.completedClasses=completedClasses;
	}
//	END CONSTRUCTORS

	/**
	*		enrolls student in a single section class. section still stored in gradebook storage
	*
	*/
	public void enroll(Class aClass, Section section){
		GradebookStorage sections= new GradebookStorage();
		sections.add(section);
		enroll(aClass, sections);
		}
	/**	enrolls a student in a class that has multuple sections.
	*
	*
	*/
	public void enroll(Class aClass, GradebookStorage sections){
		enrolledClasses.add(aClass);
		enrolledClasses.associate(aClass,sections);
	}

	/* each section has associated with it a group of gradebookCategories */
	public void addGradebookCategoryBySection(Section section, GradebookCategory category){
		try{
		 ((GradebookStorage)(gradebookCategoriesBySection.getAssociated(section))).add(category);
		}
		catch(Exception e){
			GradebookStorage categories = new GradebookStorage();
			categories.add(category);
			gradebookCategoriesBySection.associate(section,categories);
		}

	}

	public GradebookStorage getClassSections(Class aClass){
		return (GradebookStorage)enrolledClasses.getAssociated(aClass);
	}

	public GradebookStorage getGradebookCategoriesForSection(Section section){
		return (GradebookStorage)gradebookCategoriesBySection.getAssociated(section);
	}
	public double getAverageScore(Class aClass){
		return (new GradingScheme()).studentGrade(this,aClass);

	}
	public char getAverageLetterGrade(Class aClass){
		double aVal=(new GradingScheme()).studentGrade(this,aClass);
		if(aVal>=90) return 'A';
		else if(aVal>=80) return 'B';
		else if(aVal>=70) return 'C';
		else if(aVal>=60) return 'D';
		else return 'F';
	}


}