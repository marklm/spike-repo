package at.marklnet.markl.spikes.aspectj.pojos;

import javax.validation.constraints.Pattern;

public interface INatuerlichePerson {

    public int getAlter();
    
    public String getVorname();
    
    @Pattern(regexp = "[a-zA-Z0-9äüöÄÜÖ\\s\\.\\-\\_\\/\\*\\~]*")
    public String getNachname();
    
}
