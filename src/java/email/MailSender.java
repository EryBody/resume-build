package email;

import java.io.FileNotFoundException;
import java.io.InputStream;
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
public class MailSender {

    public void sendMail(String reciepent, EmailCompositeBean bean) throws MessagingException {

        try{
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        
        Properties prop = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("prop/email.properties");
        
        if(inputStream!=null){
            prop.load(inputStream);
        }else{
            throw new FileNotFoundException("Property File not Found");
        }

        properties.put("mail.smtp.host", prop.getProperty("SMTP_HOST"));
        properties.put("mail.smtp.auth", prop.getProperty("SMTP_AUTH"));
        properties.put("mail.smtp.starttls.enable", prop.getProperty("STAR_ENABLE"));
        properties.put("mail.smtp.ssl.trust", prop.getProperty("SSL_TRUST"));
        properties.put("mail.smtp.port", prop.getProperty("SMTP_PORT"));

        String myAccountEmail = prop.getProperty("EMAIL");
        String password = prop.getProperty("PASSWORD");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }

        });

        Message message = prepareMessage(session, myAccountEmail, reciepent, bean);
        Transport.send(message);
        System.out.println("Message sent Successfully");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private Message prepareMessage(Session session, String myAccountEmail, String reciepent, EmailCompositeBean bean) {
        try {
            MailTemplate mailTemplate = new MailTemplate();

            String registrationMsg = mailTemplate.registrationMail(bean.getName());

            Message mesage = new MimeMessage(session);
            mesage.setFrom(new InternetAddress(myAccountEmail));
            mesage.setRecipient(Message.RecipientType.TO, new InternetAddress(reciepent));
            mesage.setSubject("Precious Resume");
            mesage.setContent(registrationMsg, "text/html");

            return mesage;
        } catch (Exception ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
