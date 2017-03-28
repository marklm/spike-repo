package at.markl.spikes.re.drools.service;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import at.markl.spikes.re.drools.data.ControllActionTyp;
import at.markl.spikes.re.drools.data.TempMeasurement;

public class SimpleHeatingRuleServiceTest {
	
	private SimpleHeatingRuleService service = new SimpleHeatingRuleService();
	
	private static final float defaultReqTemp = 22.5f;
	private static final LocalDateTime time = LocalDateTime.now();

	@Test
	public void heating() {		
		final TempMeasurement tempMeasurement = new TempMeasurement(time, defaultReqTemp, 21.4f);
		service.evaluateTemparature(tempMeasurement);	
		assertEquals(ControllActionTyp.DO_HEATING, tempMeasurement.getEvaluatedAction());
	}
	
	@Test
	public void nothing() {
		assertEquals(ControllActionTyp.DO_NOTHING, 
					service.evaluateTemparature(new TempMeasurement(time, defaultReqTemp, 21.5f)));
		assertEquals(ControllActionTyp.DO_NOTHING, 
				service.evaluateTemparature(new TempMeasurement(time, defaultReqTemp, 23.5f)));
	}
	
	@Test
	public void cooling() {
		assertEquals(ControllActionTyp.DO_COOLING, 
					service.evaluateTemparature(new TempMeasurement(time, defaultReqTemp, 23.6f)));
	}

}
