package at.marklnet.markl.spikes.aspectj.pojos;

import java.lang.reflect.Method;

import javax.validation.constraints.Pattern;

import at.marklnet.markl.spikes.aspectj.annotations.PatternAdded;

public class NatuerlichePerson implements INatuerlichePerson {

    private String vorname;
    
    private String nachname;
    
    private int alter;
    
    public String getVorname() {
        return vorname;
    }


    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public int getAlter() {
        return alter;
    }
    
//    @Pattern(regexp = "[a-zA-Z0-9äüöÄÜÖ\\s\\.\\-\\_\\/\\*\\~]*")
    public String getNachname() {
        return nachname;
    }


    public void setNachname(String nachname) {
        this.nachname = nachname;
    }


    public void setAlter(int alter) {
        this.alter = alter;
    }


    public String handleSomething() {
        return "ok";
    }
   
    
    public static void main(String[] args) {
        boolean atLeastOne = false;
        final Method[] declaredMethods = NatuerlichePerson.class.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            final Method current = declaredMethods[i];
            if (current.isAnnotationPresent(Pattern.class)) {
                atLeastOne = true;
                System.out.println(String.format("Method '%s' is annotated with @Pattern", current.getName()));
            }
            if (current.isAnnotationPresent(PatternAdded.class)) {
                atLeastOne = true;
                System.out.println(String.format("Method '%s' is annotated with @PatternAdded", current.getName()));
            }
        }
        if (!atLeastOne) {
            System.out.println("No Method is annotated.");
        }
    }
    
}
