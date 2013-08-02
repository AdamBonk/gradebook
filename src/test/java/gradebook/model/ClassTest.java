package gradebook.model;

import org.junit.*;
import static org.junit.Assert.*;

public class ClassTest {

	private Course  courseA;
	private Class 	classA;
	private Section sectionA;
	private Section sectionB;
	private Student studentAA;
	private Student studentAB;
	private Student studentBA;
	private Student studentBB;
	private GradebookCategory newCat;
	private GradebookCategory newDog;
	private GradebookItem itemA;
	private GradebookItem itemB;
	private GradebookItem itemC;
	private GradebookItem itemD;
	private GradebookItem someA;
	private GradebookItem someB;
	private GradebookStorage storedItems;

	@Before
	public void setup() {
		courseA = new Course("CS","stuff",2340);
		classA 	= new Class(courseA, "SPRING2014");
		sectionA = new Section(classA,"SECTIONA");
		sectionB = new Section(classA,"SECTIONB");
		studentAA = new Student("JimBob");
		studentAB  = new Student("billyBoy");
		studentBA = new Student("someone");
		studentBB  = new Student("someoneelse");
		newCat = new GradebookCategory("cat",.5);
		newDog = new GradebookCategory("dog",.5);
		itemA = new GradebookItem("chocolate" , 92);
		itemB = new GradebookItem(24);
		itemC = new GradebookItem("sugar" , 100);
		itemD = new GradebookItem("flour" , 55);
		someA = new GradebookItem("bark", 99);
		someB = new GradebookItem("stuff", 80);
		sectionA.addStudent(studentAA);
		sectionA.addStudent(studentAB);
		sectionB.addStudent(studentBA);
		sectionB.addStudent(studentBB);
		sectionA.addGradebookCategory(newCat);
		sectionA.addGradebookCategory(newDog);
		sectionB.addGradebookCategory(newCat);
		sectionB.addGradebookCategory(newDog);
		studentAA.addGrade(sectionA, "cat", itemA);
		studentAA.addGrade(sectionA, "cat", itemB);
		studentAA.addGrade(sectionA, "cat", itemC);
		studentAA.addGrade(sectionA, "cat", itemD);
		studentAA.addGrade(sectionA, "dog", someA);
		studentBB.addGrade(sectionB, "cat", itemA);
		studentBB.addGrade(sectionB, "cat", itemB);
		studentBB.addGrade(sectionB, "cat", itemC);
		studentBB.addGrade(sectionB, "cat", itemD);
		studentBB.addGrade(sectionB, "dog", someB);
		studentAB.addGrade(sectionA, "cat", itemA);
		studentAB.addGrade(sectionA, "cat", itemB);
		studentAB.addGrade(sectionA, "cat", itemC);
		studentAB.addGrade(sectionA, "cat", itemD);
		studentAB.addGrade(sectionA, "dog", someA);
		studentBA.addGrade(sectionB, "cat", itemA);
		studentBA.addGrade(sectionB, "cat", itemB);
		studentBA.addGrade(sectionB, "cat", itemC);
		studentBA.addGrade(sectionB, "cat", itemD);
		studentBA.addGrade(sectionB, "dog", someB);
	}
	@Test
	public void averageTest() {
		System.out.println(classA.getAverageScore());
		assertTrue(classA.getAverageScore() ==78.625);
		assertTrue(classA.getAverageLetterGrade() == 'C');

	}
}