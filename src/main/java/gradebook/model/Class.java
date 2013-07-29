package main.java.gradebook.model;

import main.java.gradebook.model.*;
import java.util.Iterator;


public class Class extends Course{
/*
	formatting of semester can be formatted as
	"SPRING2013"
*/
	private String semester;
	private GradebookStorage sections;
//  INSTRUCTOR


//	BEGIN CONSTRUCTORS
	public Class(Course course, String semester){
		super(course);
		this.semester=semester;
	}
	public Class(Course course, String semester, GradebookStorage sections){
		super(course);
		this.semester=semester;
		this.sections=sections;
	}
	public Class(Course course, String semester, GradebookStorage sections, String newDescription){
		super(course);
		this.semester=semester;
		this.sections=sections;
		this.description=newDescription;
	}
//	END CONSTRUCTORS


/*	Add error catching for section that already exists*/
	public void addSection(Section section ){
		sections.add(section);
	}


	public double getAverageScore(){
		int numberOfSections = sections.size();
		int totalVal=0;
		Iterator sectionIt = sections.iterator();
		while(sectionIt.hasNext()){
			totalVal+=((Section)sectionIt.next()).getAverageScore(this);
		}
		return (totalVal/numberOfSections);
	}


	public char getAverageLetterGrade(){
		int numberOfSections = sections.size();
		double letterTotalVal=0;
		Iterator sectionIt = sections.iterator();
		while(sectionIt.hasNext()){
			char letter = ((Section)sectionIt.next()).getAverageLetterGrade(this);
			int letterVal=0;
			switch(letter){
				case 'A': letterVal=4;
				break;
				case 'B': letterVal=3;
				break;
				case 'C': letterVal=2;
				break;
				case 'D': letterVal=1;
				break;
				case 'F': letterVal=0;
				break;
			}
			letterTotalVal+=letterVal;
		}
		double finalVal= letterTotalVal/numberOfSections;
		if(finalVal==4) 		return 'A';
		else if(finalVal>=3) 	return 'B';
		else if(finalVal>=2)	return 'C';
		else if(finalVal>=1)	return 'D';
		else					return 'F';

	}

}