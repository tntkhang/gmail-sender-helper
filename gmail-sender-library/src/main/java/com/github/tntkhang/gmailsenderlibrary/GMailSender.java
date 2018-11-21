package com.github.tntkhang.gmailsenderlibrary;

public class GMailSender {

    private String email;
    private String pass;

    public GMailSender(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public void sendMail(String title, String body, String emailAddress, String sender, IListener listener) {
        try {
            GMailSenderAuthenticator mailSender = new GMailSenderAuthenticator(email, pass, listener);
            mailSender.sendMail(title, body, sender, emailAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
