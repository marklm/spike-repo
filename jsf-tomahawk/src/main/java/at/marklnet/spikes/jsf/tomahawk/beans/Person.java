package at.marklnet.spikes.jsf.tomahawk.beans;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

@AutoProperty
public class Person implements Serializable {

	private static final long serialVersionUID = -3619759892848607240L;

	public final static Pattern TO_STRING_PATTERN = 
		Pattern.compile("Person\\{name: \\{([\\w\\s]+)\\}, personalNumber: \\{([\\w\\s]+)\\}, departement: \\{([\\w\\s_-]+)\\}\\}");
	
	
	private String name;	

	private String personalNumber;
	
	private String departement;
	

	public Person() {

	}
	
	/**
	 * @param name
	 * @param personalNumber
	 * @param departement
	 */
	public Person(String name, String personalNumber, String departement) {
		this.name = name;
		this.personalNumber = personalNumber;
		this.departement = departement;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the personalNumber
	 */
	public String getPersonalNumber() {
		return personalNumber;
	}

	/**
	 * @param personalNumber the personalNumber to set
	 */
	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	/**
	 * @return the departement
	 */
	public String getDepartement() {
		return departement;
	}

	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
	public static Person fromString(String string) {
		//Input something like: Person{name: {Markus Toth}, personalNumber: {12345}, departement: {brz-ext}}
				
		final Matcher matcher = TO_STRING_PATTERN.matcher(string.toString());
		
		if(matcher.matches()) {
			final Person person = new Person(matcher.group(1), matcher.group(2), matcher.group(3));
			System.out.println("fromString creates: " + person.toString());
			return person;
		}
		throw new IllegalArgumentException("Unparseable string, unable to produce instance. " + string);
	}
	
	@Override
	public String toString() {
		// Produces something like: Person{name: {Markus Toth}, personalNumber: {12345}, departement: {brz-ext}}
		return Pojomatic.toString(this);
	}
	
	@Override
	public boolean equals(Object other) {
		return Pojomatic.equals(this, other);
	}
}
