package at.marklnet.spikes.jsf.tomahawk.beans;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {
	
	@Test
	public void fromString() {
		
		// Person{name: {Markus Markl}, personalNumber: {12345}, departement: {e-dc-et}}
		
		final Person test = new Person("Markus Markl", "12345", "e-dc-et");
		
		assertEquals("Person{name: {Markus Markl}, personalNumber: {12345}, departement: {e-dc-et}}", test.toString());
		
		final Person result = Person.fromString(test.toString());
		
		assertEquals(test, result);

	}

}
