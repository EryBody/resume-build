    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package email;



    /**
     *
     * @author HP PAVILLION
     */
    public class MailTemplate {

        public String registrationMail(String uname) {
            String message = "<body style=\"margin:0px; background: " + EmailCodes.BODY_BACKGROUND + "; \">\n"
                    + "    <div width=\"100%\" style=\"background: " + EmailCodes.BODY_BACKGROUND + "; padding: 0px 0px; font-family:arial; line-height:28px; height:100%;  width: 100%; color: #514d6a;\">\n"
                    + "        <div style=\"max-width: 700px; padding:50px 0;  margin: 0px auto; font-size: 14px\">\n"
                    + "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin-bottom: 20px\">\n"
                    + "                <tbody>\n"
                    + "                    <tr>\n"
                    + "                        <!-- <td style=\"vertical-align: top; padding-bottom:30px;\" align=\"center\"><a href=\"http://eliteadmin.themedesigner.in\" target=\"_blank\"><img src=\"brand-logo.png\" alt=\"HNG Intership\" style=\"border:none\"><br/>\n"
                    + "                            <img src=\"brand-logo.png\" alt=\"HNG Intership\" style=\"border:none\"></a>\n"
                    + "                        </td> -->\n"
                    + "                    </tr>\n"
                    + "                </tbody>\n"
                    + "            </table>\n"
                    + "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%;\">\n"
                    + "                <tbody>\n"
                    + "                    <tr>\n"
                    + "                        <td style=\"background:" + EmailCodes.TD_BACKGROUND + "; padding:20px; color:#fff; text-align:center;\">Appreciation Mail. </td>\n"
                    + "                    </tr>\n"
                    + "                </tbody>\n"
                    + "            </table>\n"
                    + "            <div style=\"padding: 40px; background: " + EmailCodes.DIV_BACKGROUND + ";\">\n"
                    + "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%;\">\n"
                    + "                    <tbody>\n"
                    + "                        <tr>\n"
                    + "                            <td>\n"
                    + "                                <p>Dear <b> " + uname + "</b></p>\n"
                    + "                                <p>Thank you for viewing my Resume.</p>\n"
                    + "                                <p>I look forward to meeting you:</p>\n"                              
                    + "                            </td>\n"
                    + "                        </tr>\n"
                    + "                    </tbody>\n"
                    + "                </table>\n"
                    + "            </div>\n"
                    + "\n"
                    + "        </div>\n"
                    + "    </div>\n"
                + "</body>";
        return message;
    }
}
