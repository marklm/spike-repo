package at.markl.spikes.re.drools.data;

import java.time.LocalDateTime;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TempMeasurement {
	
	private LocalDateTime timestamp;
	
	private float requiredTemp;
	
	private float currentTemp;
	
	private ControllActionTyp evaluatedAction = ControllActionTyp.DO_NOTHING;
	
	public TempMeasurement() {
		System.out.println("Default");
	}
	
	public TempMeasurement(LocalDateTime timestamp, float requiredTemp, float currentTemp) {
		this.timestamp = timestamp;
		this.requiredTemp = requiredTemp;
		this.currentTemp = currentTemp;
	}
	
	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * @return the requiredTemp
	 */
	public float getRequiredTemp() {
		return requiredTemp;
	}

	/**
	 * @return the currentTemp
	 */
	public float getCurrentTemp() {
		return currentTemp;
	}
	
	
	/**
	 * @return the action
	 */
	public ControllActionTyp getEvaluatedAction() {
		return evaluatedAction;
	}

	/**
	 * @param action the action to set
	 */
	public void setEvaluatedAction(ControllActionTyp action) {
		this.evaluatedAction = action;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	

}
