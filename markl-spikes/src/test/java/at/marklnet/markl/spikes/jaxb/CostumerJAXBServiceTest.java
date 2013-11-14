package at.marklnet.markl.spikes.jaxb;

import static org.junit.Assert.*;

import org.junit.Test;

import at.marklnet.markl.spikes.jaxb.dtos.Customer;
import at.marklnet.markl.spikes.jaxb.service.CustomerJAXBService;
import at.marklnet.markl.spikes.jaxb.service.JAXBService;

/**
 * 
 * @author Markl
 */
public class CostumerJAXBServiceTest {
    
    private static final JAXBService<Customer> SERVICE = new CustomerJAXBService();
    
    /**
     * Test simple to xml.
     */
    @Test
    public void toXml() {
        final CharSequence xml = SERVICE.toXML(new Customer("Max Mustermann", 23, 1));
        
        assertNotNull(xml);
        System.out.println(xml);
    }
    
    /**
     * Test simple from String.
     */
    @Test
    public void fromXML() {
        final Customer customer = SERVICE.fromXML("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer><name>Max Mustermann</name><age>23</age><id>1</id></customer>");     
        assertNotNull(customer);
        assertEquals(new Customer("Max Mustermann", 23, 1), customer);
    }

}
