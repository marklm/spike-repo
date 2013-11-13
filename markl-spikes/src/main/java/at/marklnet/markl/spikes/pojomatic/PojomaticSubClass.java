package at.marklnet.markl.spikes.pojomatic;

import org.pojomatic.annotations.AutoProperty;

@AutoProperty
public class PojomaticSubClass extends ABaseClass {
	
	private String someThing;

	/**
	 * @return the someThing
	 */
	public String getSomeThing() {
		return someThing;
	}

	/**
	 * @param someThing the someThing to set
	 */
	public void setSomeThing(String someThing) {
		this.someThing = someThing;
	}
}
