package at.marklnet.markl.spikes.aspectj.services;

import at.marklnet.markl.spikes.utils.GlasUtils;

/**
 * Dummy Service.
 * 
 * @author <a href="mailto:markus.markl@brz.gv.at">Markus Markl</a>
 */
public class DummyService {
    
    public String currentDateToString() {
        return GlasUtils.now().toString();
    }

}
