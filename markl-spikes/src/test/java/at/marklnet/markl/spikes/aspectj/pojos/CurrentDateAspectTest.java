package at.marklnet.markl.spikes.aspectj.pojos;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import at.marklnet.markl.spikes.aspectj.services.DummyService;
import at.marklnet.markl.spikes.utils.GlasUtils;

public class CurrentDateAspectTest {
    
    @Test
    public void currentDateToStringAspect() {
        
        final Date expectedDate = GlasUtils.getDateFor(1, 1, 2000, true);   
        
        // GlasUtils.now() must be overriden by aspect
        Assert.assertEquals(expectedDate.toString(), new DummyService().currentDateToString());
    }
}
