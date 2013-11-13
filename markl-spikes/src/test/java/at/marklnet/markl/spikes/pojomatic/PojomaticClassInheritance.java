package at.marklnet.markl.spikes.pojomatic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PojomaticClassInheritance {
	
	@Test
	public void baseClassWithFields() {
		PojomaticClass2 test = new PojomaticClass2();
		test.setSomeThing("test_1");
		test.setSomeThing2("test_2");
		
		PojomaticClass2 test2 = new PojomaticClass2();
		test2.setSomeThing("test_1");
		test2.setSomeThing2("test_2");
		
		assertEquals("PojomaticClass2{someThing: {test_1}, someThing2: {test_2}}", test.toString());
		assertNotNull(null, test.hashCode());
		assertTrue(test.equals(test2));
	}
	
	@Test
	public void baseClassWithoutFields() {
		PojomaticSubClass test = new PojomaticSubClass();
		test.setSomeThing("test_1");
		
		PojomaticSubClass test2 = new PojomaticSubClass();
		test2.setSomeThing("test_1");
		
		assertEquals("PojomaticSubClass{someThing: {test_1}}", test.toString());
		assertNotNull(null, test.hashCode());
		assertTrue(test.equals(test2));
	}
}
