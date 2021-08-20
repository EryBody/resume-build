/*
 * To change this license header, choose License Headers in Project Properties.
 * To change thiss template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import javax.mail.MessagingException;

/**
 *
 * @author HP PAVILLION
 */
public class TestSendMail {
    public static void main(String[] args) throws MessagingException {
        EmailCompositeBean bean = new EmailCompositeBean();
        bean.setName("Ekwere Precious");      
        
        MailSender jma = new MailSender();
                jma.sendMail("tompreciousekwere@gmail.com",bean);
    }   
}
