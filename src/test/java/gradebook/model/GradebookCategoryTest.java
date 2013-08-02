package gradebook.model;

import org.junit.*;
import static org.junit.Assert.*;

public class GradebookCategoryTest {
	private GradebookCategory newCat;
	private GradebookItem itemA;
	private GradebookItem itemB;
	private GradebookItem itemC;
	private GradebookItem itemD;
	private GradebookStorage storedItems;

	@Before
	public void setup(){
		newCat = new GradebookCategory("cookies" , 0.3);
		itemA = new GradebookItem("chocolate" , 92);
		itemB = new GradebookItem(24);
		itemC = new GradebookItem("sugar" , 100);
		itemD = new GradebookItem("flour" , 55);
	}
	@Test
	public void testSingleAdd(){
		newCat.addItem(itemA);
		GradebookStorage someStore = newCat.getItems();
		assertTrue(someStore.contains(itemA));
	}
	@Test
	public void testWeightedAverage() {
		newCat.addItem(itemA);
		newCat.addItem(itemB);
		newCat.addItem(itemC);
		newCat.addItem(itemD);
		double total = (92+24+100+55);
		double avg = total/4;
		double wavg= avg*0.3;
		System.out.println("reported weighted average: " +
			newCat.findWeightedAverage());
		System.out.println("actual weighted average: " + wavg);
		assertTrue(newCat.findWeightedAverage() == wavg);
	}
	@Test
	public void printToString() {
		newCat.addItem(itemA);
		newCat.addItem(itemB);
		newCat.addItem(itemC);
		newCat.addItem(itemD);
		System.out.println(newCat.toString());
	}


}