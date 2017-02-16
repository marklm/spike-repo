package at.marklnet.markl.spikes.html.val;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.CharEncoding;
import org.junit.Test;

public class HtmlValidationJTidyTest {

	@Test
	public void testValidBetriebsmitteilung() throws Exception {
		final String bm = FileUtils.readFileToString(new File("./src/test/resources/bm/bm_01.txt"), CharEncoding.UTF_8);
		assertNotNull(bm);
		
		final HtmlValidationJTidy validator = new HtmlValidationJTidy();
		boolean valid = validator.isValid(bm);
		assertTrue(valid);
		
		System.out.println(validator.getPrettyPrint());
		assertTrue(bm.length() > 0);
	}
	
	@Test
	public void testInValidBetriebsmitteilung() throws Exception {
		final String bm = FileUtils.readFileToString(new File("./src/test/resources/bm/bm_02.txt"), CharEncoding.UTF_8);
		assertNotNull(bm);
		
		final HtmlValidationJTidy validator = new HtmlValidationJTidy();
		boolean valid = validator.isValid(bm);
		assertFalse(valid);
		assertNull(validator.getPrettyPrint());
		assertEquals("Zeile 9 Spalte -3 -Fehler:</div> fehlendes '>' am Ende des Tags", validator.getErrorMessage().toString());
	}
}
