package at.marklnet.spikes.jsf.tomahawk.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class PicklistBean {	

	private List<String> sourceString = new ArrayList<String>();
	
	private List<String> targetString = new ArrayList<String>();
	
	private List<Person> sourcePerson = new ArrayList<Person>();
	
	private List<Person> targetPerson = new ArrayList<Person>();

	public PicklistBean() {
		sourceString.add("String_1");
		sourceString.add("String_2");
		sourceString.add("String_3");
		sourceString.add("String_4");
		sourceString.add("String_5");

		
		sourcePerson.add(new Person("Markus Markl", "12345", "e-dc-et"));
		sourcePerson.add(new Person("Markus Toth", "12345", "brz-ext"));
		sourcePerson.add(new Person("Milan Jovanovic", "12388", "brz-ext"));
	}

	public void selectionChanged(ValueChangeEvent evt) {
		
		Object newValue = evt.getNewValue();
		if (newValue instanceof List) {
			List selectedValues = (List) evt.getNewValue();
			if (selectedValues.size() == 0) {
				System.out.println("No change....");
			} else {
				for (int i = 0; i < selectedValues.size(); i++) {
					System.out.println("Value[" + i +"]: type=" + selectedValues.get(i).getClass().getCanonicalName() 
							+ " value=" + selectedValues.get(i).toString());
				}
			}
		}
	}
	
	/**
	 * @return the sourcePerson
	 */
	public List<Person> getSourcePerson() {
		return sourcePerson;
	}

	/**
	 * @param sourcePerson the sourcePerson to set
	 */
	public void setSourcePerson(List<Person> sourcePerson) {
		this.sourcePerson = sourcePerson;
	}

	/**
	 * @return the targetPerson
	 */
	public List<Person> getTargetPerson() {
		return targetPerson;
	}

	/**
	 * @param targetPerson the targetPerson to set
	 */
	public void setTargetPerson(List<Person> targetPerson) {
		this.targetPerson = targetPerson;
		System.out.println("setTargetPerson called.... size=" + targetPerson.size());
	}

	/**
	 * @return the sourceString
	 */
	public List<String> getSourceString() {
		return sourceString;
	}

	/**
	 * @param sourceString the sourceString to set
	 */
	public void setSourceString(List<String> sourceString) {
		this.sourceString = sourceString;
	}

	/**
	 * @return the targetString
	 */
	public List<String> getTargetString() {
		return targetString;
	}

	/**
	 * @param targetString the targetString to set
	 */
	public void setTargetString(List<String> targetString) {
		this.targetString = targetString;
		System.out.println("setTargetString called.... size=" + targetString.size());
	}
}
