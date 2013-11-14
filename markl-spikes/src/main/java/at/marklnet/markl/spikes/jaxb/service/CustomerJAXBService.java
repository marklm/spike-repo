package at.marklnet.markl.spikes.jaxb.service;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;

import at.marklnet.markl.spikes.jaxb.dtos.Customer;

/**
 * 
 * @author Markus Markl
 */
public class CustomerJAXBService implements JAXBService<Customer> {
    
    private static final JAXBContext JAXB_CONTEXT;
    
    static {
        try {
            JAXB_CONTEXT = JAXBContext.newInstance(Customer.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    

    @Override
    public CharSequence toXML(Customer dto) {
        final StringWriter writer = new StringWriter();
        try {
            final Marshaller jaxbMarshaller = JAXB_CONTEXT.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(dto, writer);    
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }  
        return writer.toString();
    }

    @Override
    public Customer fromXML(CharSequence xml) {
        Customer customer = null;
        try {
            final InputStream stream = IOUtils.toInputStream(xml);
            
            Unmarshaller jaxbUnmarshaller = JAXB_CONTEXT.createUnmarshaller();
            customer = (Customer) jaxbUnmarshaller.unmarshal(stream);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }
}
