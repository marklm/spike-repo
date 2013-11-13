package at.marklnet.markl.spikes.pojomatic;

import org.pojomatic.annotations.AutoProperty;

@AutoProperty
public class PojomaticClass2 extends PojomaticClass {
	
	private String someThing2;

	/**
	 * @return the someThing2
	 */
	public String getSomeThing2() {
		return someThing2;
	}

	/**
	 * @param someThing2 the someThing2 to set
	 */
	public void setSomeThing2(String someThing2) {
		this.someThing2 = someThing2;
	}

}
