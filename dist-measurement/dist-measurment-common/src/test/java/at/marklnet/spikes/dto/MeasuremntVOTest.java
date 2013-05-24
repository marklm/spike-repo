package at.marklnet.spikes.dto;

import java.util.Date;
import org.junit.Test;
import at.marklnet.spikes.enums.MeasurementType;
import static org.junit.Assert.*;

/**
 * Simple Unit Test. 
 * 
 * Eigentlich nur um Pojomatic zu testen.
 * 
 * @author Markus Markl
 */
public class MeasuremntVOTest {
	
	@Test
	public void equal() {
		final Date d = new Date();
		final String adress = "AS-101/25'1";
		final float value = 1.1F;
		assertEquals(new MeasurementVO(MeasurementType.TEMP, value, d, adress), new MeasurementVO(MeasurementType.TEMP, value, d, adress));
	}
	
	@Test
	public void toStringTest() {
		final Date d = new Date();
		final String adress = "AS-101/25'1";
		final float value = 1.1F;
		
		final String expected = String.format("MeasurementVO{type: {TEMP}, value: {1.1}, timestamp: {%s}, adress: {AS-101/25'1}}", d);
		
		assertEquals(expected, 
				new MeasurementVO(MeasurementType.TEMP, value, d, adress).toString());
	}

	
	
}
