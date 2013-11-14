package at.marklnet.markl.spikes.jaxb.service;

/**
 * Service definition for Base JAXB Services.
 * 
 * @author Markus Markl
 *
 * @param <TYPE> Type to handle
 */
public interface JAXBService<TYPE> {

    /**
     * Marshalls given dto to an XML output.
     * 
     * @param dto dto to marshall
     * 
     * @return a XML representation as {@link CharSequence}
     */
    CharSequence toXML(TYPE dto);
    
    /**
     * Unmarshalls the given XML to a DTO.
     * 
     * @param xml to transform
     * 
     * @return a corresponding DTO
     */
    TYPE fromXML(CharSequence xml);
    
}
