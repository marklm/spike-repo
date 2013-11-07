package at.marklnet.markl.spikes.aspectj.aspects;

import java.util.Date;

import at.marklnet.markl.spikes.utils.GlasUtils;

public aspect GlasUitlsAspect {

    pointcut now() : call (public static Date at.marklnet.markl.spikes.utils.GlasUtils.now());
    
    Date around() : now() {
        final Date now = proceed();
        final Date fakeDate = GlasUtils.getDateFor(1, 1, 2000, true);
        
        System.out.println("Aspect fakes date! Acutually " + now + " is faked with " + fakeDate);
        
        return fakeDate;
    };

}
