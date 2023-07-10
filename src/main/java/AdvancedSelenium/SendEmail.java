package AdvancedSelenium;

import org.apache.commons.mail.*;

import java.io.File;

public class SendEmail {
    public static void main(String[] args) throws EmailException {

        MultiPartEmail email = new MultiPartEmail();

        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("shaik.arifa@zemosolabs.com","lvyhpukoxzkzxrvy"));
        email.setSSLOnConnect(true);
        email.setFrom("shaik.arifa@zemosolabs.com");
        email.setSubject("generated Report from Selenium ");
        email.setMsg("This is test mail from selenium");
        email.addTo("shaikarifa.asha@gmail.com");

//        //create attachment
//        EmailAttachment attachment = new EmailAttachment();
//        attachment.setPath(String.valueOf(new File("/home/shaiA/selinium/selinium_practise/test-output/Extent.html")));
//        attachment.getDisposition();
//        attachment.setDescription("Selenium Report");
//        attachment.setName("Report.html");
//
//        email.attach(attachment);

        email.send();

        System.out.println("sent msg successfully..........");
    }
}
