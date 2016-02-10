package at.marklnet.markl.spikes.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple Mail Test.
 * 
 * @author marklm
 */
public class MailServiceTest {

    /**
     * Sends directly using the configured smtp server.
     */
    @Test
    public void sendMailDirect() throws AddressException, MessagingException {
        final Properties props = new Properties();
        props.put("mail.smtp.host", "172.18.8.30");
        final Session session = Session.getInstance(props, null);

            final MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("Company XYZ <mail@companyxyz.com>"));
            msg.setRecipients(Message.RecipientType.TO, "markus.markl@brz.gv.at");
            msg.setSubject("JavaMail - Spike to test Java Mail");
            msg.setSentDate(new Date());
            msg.setText("Hello, world!\n");
            Transport.send(msg);

    }
    
    /**
     * 
     * https://javamail.java.net/nonav/docs/api/
     * 
     * Sends the mail using new configuration.
     * @throws MessagingException 
     * @throws AddressException 
     */
    @Test
    public void sendMailnewSMTP() throws AddressException, MessagingException {
        final Properties props = new Properties();
        props.put("mail.smtp.host", "172.18.105.14");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.ssl.trust", "172.18.105.14");
//        props.put("mail.transport.protocol", "smtps");
        
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback", "false");
        
        final String username = "svc_glsp_jenkins";
        final String password = "ScjPQbdqK2YWZ6g";
        
        
        final Authenticator authenticator = new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() { 
                return new PasswordAuthentication(username, password);
          }
        };
        
        final Session session = Session.getInstance(props, authenticator);
        session.setDebug(true);
        

           final MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("Company XYZ <mail@companyxyz.com>"));
            msg.setRecipients(Message.RecipientType.TO, "markus.markl@brz.gv.at");
            msg.setSubject("JavaMail - Spike to test Java Mail - TSL");
            msg.setSentDate(new Date());
            msg.setText("Hello, world!\n");
            Transport.send(msg);

    }
    
    /**
     * 
     * https://javamail.java.net/nonav/docs/api/
     * 
     * Sends the mail using new configuration.
     * @throws MessagingException 
     * @throws AddressException 
     */
    @Test
    public void sendMailnewSMTPViaTSL() throws AddressException, MessagingException {
        final Properties props = new Properties();
        props.put("mail.smtp.host", "172.18.105.14");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "172.18.105.14");
//        props.put("mail.transport.protocol", "smtps");
        
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        
        final String username = "svc_glsp_jenkins";
        final String password = "ScjPQbdqK2YWZ6g";
        
        
        final Authenticator authenticator = new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() { 
                return new PasswordAuthentication(username, password);
          }
        };
        
        final Session session = Session.getInstance(props, authenticator);
        session.setDebug(true);
        

           final MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("Company XYZ <mail@companyxyz.com>"));
            msg.setRecipients(Message.RecipientType.TO, "markus.markl@brz.gv.at");
            msg.setSubject("JavaMail - Spike to test Java Mail - TSL");
            msg.setSentDate(new Date());
            msg.setText("Hello, world!\n");
            Transport.send(msg);

    }

}
