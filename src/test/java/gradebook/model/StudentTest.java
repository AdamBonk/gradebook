package gradebook.model;

import org.junit.*;
import static org.junit.Assert.*;

public class StudentTest {


	private Course  courseA;
	private Class 	classA;
	private Section sectionA;
	private Student studentAlpha;
	private GradebookCategory newCat;
	private GradebookItem itemA;
	private GradebookItem itemB;
	private GradebookItem itemC;
	private GradebookItem itemD;
	private GradebookStorage storedItems;

	@Before
	public void setup() {
		courseA = new Course("CS","stuff",2340);
		classA 	= new Class(courseA, "SPRING2014");
		sectionA = new Section(classA,"SECTIONA");
		studentAlpha = new Student("JimBob");

		newCat = new GradebookCategory("cat",1);
		itemA = new GradebookItem("chocolate" , 92);
		itemB = new GradebookItem(24);
		itemC = new GradebookItem("sugar" , 100);
		itemD = new GradebookItem("flour" , 55);

	}
	@Test
	public void enrollTest(){
		studentAlpha.enroll(classA , sectionA);
		assertTrue(sectionA.hasStudent(studentAlpha));
	}

	@Test
	public void getAverageScoreTest() {
		studentAlpha.enroll(classA , sectionA);
		sectionA.addGradebookCategory(newCat);
		studentAlpha.addGrade(sectionA,"cat",itemA);
		studentAlpha.addGrade(sectionA,"cat",itemB);
		studentAlpha.addGrade(sectionA,"cat",itemC);
		studentAlpha.addGrade(sectionA,"cat",itemD);
		assertTrue(studentAlpha.getAverageScore(classA) == 67.75);
	}
	@Test
	public void getClassSectionTest() {
		studentAlpha.enroll(classA , sectionA);
		assertTrue(studentAlpha.getClassSection(classA).equals(sectionA));

	}
	@Test
	public void letterGradeTest() {
		studentAlpha.enroll(classA , sectionA);
		sectionA.addGradebookCategory(newCat);
		studentAlpha.addGrade(sectionA,"cat",itemA);
		studentAlpha.addGrade(sectionA,"cat",itemB);
		studentAlpha.addGrade(sectionA,"cat",itemC);
		studentAlpha.addGrade(sectionA,"cat",itemD);
		assertTrue(studentAlpha.getAverageLetterGrade(classA) == 'D');
	}
}