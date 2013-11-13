package at.marklnet.markl.spikes.pojomatic;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

@AutoProperty
public class APojomaticBase {
	
	@Override
	public int hashCode() {
		return Pojomatic.hashCode(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		return Pojomatic.equals(this, other);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Pojomatic.toString(this);
	}
}
