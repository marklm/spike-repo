package at.marklnet.spikes.dto;

import java.util.Date;

import org.pojomatic.annotations.AutoProperty;

import at.marklnet.spikes.enums.MeasurementType;

/**
 * Simples VO für Messungen.
 * 
 * @author Markus Markl
 */
@AutoProperty
@SuppressWarnings("serial")
public class MeasurementVO extends AValueObject {
	
	private MeasurementType type;
	
	private float value;
	
	private Date timestamp;
	
	private String adress;
	
	/**
	 * Default c'tor;
	 */
	public MeasurementVO() {

	}

	/**
	 * Convenience c'tor.
	 * @param type type of Measurement
	 * @param value value of
	 * @param timestamp timestamp of
	 * @param adress adress of
	 */
	public MeasurementVO(MeasurementType type, float value, Date timestamp, String adress) {
		super();
		this.type = type;
		this.value = value;
		this.timestamp = timestamp;
		this.adress = adress;
	}

	/**
	 * @return the type
	 */
	public MeasurementType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(MeasurementType type) {
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public float getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(float value) {
		this.value = value;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
}
