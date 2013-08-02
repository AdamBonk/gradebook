package gradebook.model;

import org.junit.*;
import static org.junit.Assert.*;

public class GradebookItemTest {
	private GradebookCategory cat;
	private GradebookItem item;

	@Before
	public void setUp(){
		item = new GradebookItem(93);
		cat = new GradebookCategory("Cat",0.5);

	}

	@Test
	public void testUnnamed(){
		assertTrue(item.getName().equals("Unnamed"));
	}
	@Test
	public void testToString(){
		item.setName("Test 1");
		assertTrue(item.toString().equals("Test 1    : 93.0\n"));
	}

	@Test
	public void testName(){
		item.setName("Test 1");
		assertTrue(item.getName().equals("Test 1"));
	}
	@Test
	public void testGetCategoryWeight(){
		GradebookItem anItem = new GradebookItem("disection",80);
		cat.addItem(anItem);
		assertTrue(anItem.getWeightOfCategory()==0.5);
	}

}