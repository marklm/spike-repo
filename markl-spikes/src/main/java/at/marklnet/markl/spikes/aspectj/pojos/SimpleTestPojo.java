package at.marklnet.markl.spikes.aspectj.pojos;


/**
 * Mit Aspekten werden Methoden bearbeitet.
 * 
 * @author <a href="mailto:markus.markl@brz.gv.at">Markus Markl</a>
 */
public class SimpleTestPojo {
    
    public String getText() {
        return "Statischer Text";
    }
    
    public static void main(String[] args) {
        final SimpleTestPojo pojo = new SimpleTestPojo();
        
        System.out.println("Hello world - " + pojo.getText());
    }

}
