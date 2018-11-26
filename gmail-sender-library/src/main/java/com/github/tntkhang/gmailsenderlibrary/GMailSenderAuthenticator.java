package com.github.tntkhang.gmailsenderlibrary;

import java.security.Security;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class GMailSenderAuthenticator extends Authenticator {
    static {
        Security.addProvider(new JSSEProvider());
    }

    private String user;
    private String password;
    private Session session;
    private GmailListener listener;

    GMailSenderAuthenticator(String username, String password, GmailListener listener) {
        this.user = username;
        this.password = password;
        this.listener = listener;

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");

        session = Session.getDefaultInstance(props, this);
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password);
    }

    synchronized void sendMail(String subject, String body, String sender, String recipients) {
        SendMailTask sendMailTask = new SendMailTask(subject, body, sender, recipients, listener, session);
        sendMailTask.execute();
    }
}