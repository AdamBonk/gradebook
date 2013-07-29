package main.java.gradebook.model;

import main.java.gradebook.model.*;
import java.util.Iterator;



public class Section{

	private String name;
	private GradebookStorage students;

//	BEGIN CONSTRUCTORS
	public Section(GradebookStorage students){
		this.students=students;
	}
	public Section(String name, GradebookStorage students){
		this.name=name;
		this.students=students;
	}
//	END CONSTRUCTORS



/*	Add error catching for student that already exists*/
	public void addStudent(Student student){
		students.add(student);
	}




	public double getAverageScore(Class aClass){
		int numberOfStudents = students.size();
		int totalVal=0;
		Iterator studentIt = students.iterator();
		while(studentIt.hasNext()){
			totalVal+=((Student)studentIt.next()).getAverageScore(aClass);
		}
		return (totalVal/numberOfStudents);
	}

	public char getAverageLetterGrade(Class aClass){
		int numberOfStudents = students.size();
		double letterTotalVal=0;
		Iterator studentIt = students.iterator();
		while(studentIt.hasNext()){
			char letter = ((Student)studentIt.next()).getAverageLetterGrade(aClass);
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
		double finalVal= letterTotalVal/numberOfStudents;
		if(finalVal==4) 		return 'A';
		else if(finalVal>=3) 	return 'B';
		else if(finalVal>=2)	return 'C';
		else if(finalVal>=1)	return 'D';
		else					return 'F';

	}
}