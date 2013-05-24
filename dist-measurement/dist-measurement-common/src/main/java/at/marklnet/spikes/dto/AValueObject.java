package at.marklnet.spikes.dto;

import java.io.Serializable;

import org.pojomatic.Pojomatic;

/**
 * Pojomatic configured VO.
 * 
 * Jede Subklasse muss @AutoProperty annotieren.
 * 
 * @author Markus Markl
 */
@SuppressWarnings("serial")
public abstract class AValueObject implements Serializable {

	@Override
	public String toString() {
		return Pojomatic.toString(this);
	}
	
	@Override
	public boolean equals(Object other) {
		return Pojomatic.equals(this, other);
	}
	
	@Override
	public int hashCode() {
		return Pojomatic.hashCode(this);
	}
	
}
