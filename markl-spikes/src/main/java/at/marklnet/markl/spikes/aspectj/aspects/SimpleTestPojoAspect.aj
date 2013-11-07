package at.marklnet.markl.spikes.aspectj.aspects;

public aspect SimpleTestPojoAspect {

    pointcut mainMethod() : execution (public static void at.gv.brz.markl.spike.aspectj.pojos.SimpleTestPojo.main(String[]));
    
    pointcut text() : call (public String at.gv.brz.markl.spike.aspectj.pojos.*.getText());
    
    after() returning : mainMethod() {
        System.out.println("String added by Aspect.");
    }
    
    String around() : text() {
        final String text = proceed();
        return "!!!! geänderter Text (=> original: " + text + ")";
    };

}
