package main.java.gradebook.model;

import main.java.gradebook.model.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Dictionary;

/**
*	This class allows for quick modification of data types as it is used for every
*	long data storage in the code. (instead of arrays, or arraylists)
*/
public class GradebookStorage{
	ArrayList storage;
	Dictionary associations;

	GradebookStorage(){
		storage= new ArrayList();
	}

	public int size(){
		return storage.size();
	}

	public Iterator iterator(){
		return storage.iterator();
	}


/*	Implement error catching for incorrect type add*/
	public void add(Object object){
		storage.add(object);
	}
	public void associate(Object aClass, Object section){
		associations.put(aClass,section);
	}
	public Object getAssociated(Object classOrSection){
		return associations.get(classOrSection);
	}
}