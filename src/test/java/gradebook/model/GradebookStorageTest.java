package gradebook.model;

import org.junit.*;
import static org.junit.Assert.*;
public class GradebookStorageTest{

	private GradebookStorage storage;

	@Test
	public void associateTest(){
		storage = new GradebookStorage();
		String stringA = "a";
		String stringB = "b";
		storage.associate(stringA,stringB);
		assertTrue(stringB.equals((String) storage.getAssociated(stringA)));
	}
}