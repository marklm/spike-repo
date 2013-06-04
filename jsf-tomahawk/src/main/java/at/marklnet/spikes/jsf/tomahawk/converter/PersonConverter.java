package at.marklnet.spikes.jsf.tomahawk.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import at.marklnet.spikes.jsf.tomahawk.beans.Person;

@FacesConverter(PersonConverter.ID)
public class PersonConverter implements Converter {
	
	public final static String ID = "at.marklnet.spikes.jsf.tomahawk.converter.PersonConverter";

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value)
			throws ConverterException {
		if (value != null) {
			// Problems with ',' 
			return Person.fromString(value.replace("\\", ","));
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value)
			throws ConverterException {
		if (value != null) {
			return value.toString().replace(",", "\\");
		}
		return "";
	}

}
