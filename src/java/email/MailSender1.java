package email;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP PAVILLION
 */
public class MailSender1 {

    public void sendMail(String reciepent, EmailCompositeBean bean) throws MessagingException {
        
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "gboolzy@gmail.com";
        String password = "changegg";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }

        });
        
        Message message = prepareMessage(session, myAccountEmail, reciepent, bean);
        Transport.send(message);
        System.out.println("Message sent Successfully");
    }

    private Message prepareMessage(Session session, String myAccountEmail, String reciepent, EmailCompositeBean bean)  {
        try {
            MailTemplate mailTemplate = new MailTemplate();
            
            String registrationMsg = mailTemplate.registrationMail(bean.getName());
            
            Message mesage = new MimeMessage(session);
            mesage.setFrom(new InternetAddress(myAccountEmail));
            mesage.setRecipient(Message.RecipientType.TO, new InternetAddress(reciepent));
            mesage.setSubject("qbliz");
            mesage.setContent(registrationMsg, "text/html");


            return mesage;
        } catch (Exception ex) {
            Logger.getLogger(MailSender1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
