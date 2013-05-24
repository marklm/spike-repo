package at.marklnet.spikes.enums;

/**
 * Messart.
 * 
 * @author Markus Markl
 */
public enum MeasurementType {
	
	TEMP ("°C", "Grad Celsius"),
	
	HUMIDITY ("%", "relative Feuchtigkeit");
	
	private String unit;
	
	private String description;
	
	private MeasurementType (String unit, String description) {
		this.unit = unit;
		this.description = description;
	}

	public String getUnit() {
		return unit;
	}

	public String getDescription() {
		return description;
	}
}
