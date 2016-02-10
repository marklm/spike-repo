package at.marklnet.markl.spikes.spring.schedule;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    
    @PostConstruct
    public void init() {
        System.out.println("ScheduledService created......"); 
    }
    

    @Scheduled (cron="*/1 * * * * *")
    public void doSomething() {
        System.out.println("+doSomething() " + Thread.currentThread().getName());
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("-doSomething()" + Thread.currentThread().getName());
    }

}
