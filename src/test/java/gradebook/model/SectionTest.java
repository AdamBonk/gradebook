package gradebook.model;

import org.junit.*;
import static org.junit.Assert.*;

public class SectionTest {

	private Course  courseA;
	private Class 	classA;
	private Section sectionA;
	private Student studentAlpha;
	private Student studentBeta;
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
		studentAlpha = new Student("JimBob");
		studentBeta  = new Student("billyBoy");

		newCat = new GradebookCategory("cat",.5);
		newDog = new GradebookCategory("dog",.5);
		itemA = new GradebookItem("chocolate" , 92);
		itemB = new GradebookItem(24);
		itemC = new GradebookItem("sugar" , 100);
		itemD = new GradebookItem("flour" , 55);
		someA = new GradebookItem("bark", 99);
		someB = new GradebookItem("stuff", 80);


	}

	@Test
	public void addStudentsTest() {
		sectionA.addStudent(studentAlpha);
		sectionA.addStudent(studentBeta);
		assertTrue(sectionA.getStudents().contains(studentAlpha));
		assertTrue(sectionA.getStudents().contains(studentBeta));
		sectionA.addStudent(studentBeta);
		assertTrue(sectionA.getSize() == 2);
	}
	@Test
	public void addGradebookCategoryToStudentsTest(){
		sectionA.addStudent(studentAlpha);
		sectionA.addStudent(studentBeta);
		sectionA.addGradebookCategory(newCat);
		sectionA.addGradebookCategory(newDog);
		GradebookStorage alpha =
			studentAlpha.getGradebookCategoriesForSection(sectionA);
		GradebookStorage beta =
		studentBeta.getGradebookCategoriesForSection(sectionA);
		assertTrue(alpha.contains(newCat));
		assertTrue(beta.contains(newCat));
		assertTrue(alpha.contains(newDog));
		assertTrue(beta.contains(newDog));
	}
	@Test
	public void averageTest(){
		sectionA.addStudent(studentAlpha);
		sectionA.addStudent(studentBeta);
		sectionA.addGradebookCategory(newCat);
		sectionA.addGradebookCategory(newDog);
		studentAlpha.addGrade(sectionA, "cat", itemA);
		studentAlpha.addGrade(sectionA, "cat", itemB);
		studentAlpha.addGrade(sectionA, "cat", itemC);
		studentAlpha.addGrade(sectionA, "cat", itemD);
		studentAlpha.addGrade(sectionA, "dog", someA);
		studentBeta.addGrade(sectionA, "cat", itemA);
		studentBeta.addGrade(sectionA, "cat", itemB);
		studentBeta.addGrade(sectionA, "cat", itemC);
		studentBeta.addGrade(sectionA, "cat", itemD);
		studentBeta.addGrade(sectionA, "dog", someB);
		System.out.println(sectionA.getAverageScore());
		assertTrue(sectionA.getAverageScore() ==78.625);
		assertTrue(sectionA.getAverageLetterGrade() == 'C');

	}
}