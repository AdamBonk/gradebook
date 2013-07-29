package main.java.gradebook.model;

import main.java.gradebook.model.*;
import java.util.Iterator;



public class GradingScheme{

	public double studentGrade(Student student, Class aClass){
		GradebookStorage sections = student.getClassSections(aClass);
		double totalScore=0;

		Iterator sectionsIterator=sections.iterator();
		while(sectionsIterator.hasNext()){
			GradebookStorage categories=(GradebookStorage) sectionsIterator.next();

			Iterator categoriesIterator=categories.iterator();
			while(categoriesIterator.hasNext()){
				GradebookCategory currentCategory= (GradebookCategory)categoriesIterator.next();
				double weight=currentCategory.getWeight();
				double categoryTotal=0;
				int categorySize=currentCategory.getItems().size();

				Iterator itemsIterator=(currentCategory.getItems()).iterator();
				while(itemsIterator.hasNext()){
					categoryTotal+=((GradebookItem)itemsIterator.next()).getScore();
				}

				/*This takes the average of grades in a category and multiplies it
				by the categories weight rating to get part of the total score  */
				totalScore+= weight*(categoryTotal/categorySize);

			}
		}
		return totalScore;
	}
}