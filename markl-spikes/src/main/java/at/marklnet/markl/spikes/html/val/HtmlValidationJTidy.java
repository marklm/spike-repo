package at.marklnet.markl.spikes.html.val;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.commons.io.input.CharSequenceInputStream;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.w3c.tidy.Out;
import org.w3c.tidy.Tidy;

/**
 * Configuration: http://tidy.sourceforge.net/docs/quickref.html
 * 
 * @author marklm
 */
public class HtmlValidationJTidy {
	
	private Tidy tidy = null; 
	
	private String output = null;
	
	private String failure = null;
	
	public boolean isValid(String bm) {
		
		if (StringUtils.isBlank(bm)) {
			return false;
		}
		
		if (tidy != null) {
			throw new RuntimeException("You can call isValid only once! Create new Instance of Validator.");	
		}
		
		final OutputStream out = new ByteArrayOutputStream();
		final OutputStream err = new ByteArrayOutputStream();
		final Tidy tidy = createNewTidy(err);	

		tidy.parseDOM(getInputStream(bm), out);
		failure = err.toString();
		
		if (StringUtils.isBlank(failure)) {
			output = out.toString();
		} else {
			failure = failure.trim();
			
		}
		
		return (!StringUtils.isBlank(output) && StringUtils.isBlank(failure));
	}


	private Tidy createNewTidy(OutputStream err) {
		final Tidy tidy = new Tidy();
		this.tidy = tidy;
		tidy.setShowWarnings(false);
		tidy.setQuiet(true);
		tidy.setWraplen(0);
		tidy.setTabsize(2);
		tidy.setPrintBodyOnly(true);
		tidy.setInputEncoding(CharEncoding.UTF_8);
		tidy.setOutputEncoding(CharEncoding.UTF_8);
		tidy.setEscapeCdata(true);
		tidy.setXHTML(true);
		
		final PrintWriter errWriter = new PrintWriter(err, true);
		tidy.setErrout(errWriter);
		return tidy;
	}

	private InputStream getInputStream(String bm) {
		return new CharSequenceInputStream(bm, CharEncoding.UTF_8);
	}

	public String getPrettyPrint() {
		return output;
	}
	
	public String getErrorMessage() {
		return failure;
	}
}
