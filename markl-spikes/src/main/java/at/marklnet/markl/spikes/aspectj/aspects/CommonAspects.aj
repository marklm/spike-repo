package at.marklnet.markl.spikes.aspectj.aspects;

import javax.validation.constraints.Pattern;
import at.marklnet.markl.spikes.aspectj.annotations.PatternAdded;


/**
 * Infos http://www.eclipse.org/aspectj/doc/next/adk15notebook/annotations-declare.html
 * 
 * @author <a href="mailto:markus.markl@brz.gv.at">Markus Markl</a>
 */
public aspect CommonAspects {
   
    
    declare @method : public String at.gv.brz.markl.spike.aspectj.pojos.NatuerlichePerson+.get*() : @Pattern(regexp = "[a-zA-Z0-9äüöÄÜÖ\\s\\.\\-\\_\\/]*");
    declare @method : public String at.gv.brz.markl.spike.aspectj.pojos.NatuerlichePerson+.get*() : @PatternAdded;


}
