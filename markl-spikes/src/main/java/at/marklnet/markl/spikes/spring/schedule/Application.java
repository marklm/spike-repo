package at.marklnet.markl.spikes.spring.schedule;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        final ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("META-INF/spring/service-application-context.xml");
        
        
        Scanner scan = new Scanner(System.in);
        
        while (!scan.nextLine().equals("q")) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
}
