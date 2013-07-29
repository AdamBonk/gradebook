package main.java.gradebook.model;

import main.java.gradebook.model.*;


/** A gradebook category. Categories are held by students rather than gradebook items
*	this method of sections holding categories is different from the project description,
*	but the method defined by the description would create a category object for every
*	gradebook item, which is wasteful according to flyweight design.
*/
public class GradebookCategory{

	private String name;
	private GradebookStorage items;
	private double weight;

	public GradebookCategory(String name, GradebookStorage items, double weight){
		this.name=name;
		this.items=items;
		this.weight=weight;
	}

	public GradebookCategory(String name, double weight){
		this.name=name;
		this.weight=weight;
		items=new GradebookStorage();
	}

	public void addItem(GradebookItem item){
		items.add(item);
	}

	public double getWeight(){
		return weight;
	}

	public GradebookStorage getItems(){
		return items;
	}

}