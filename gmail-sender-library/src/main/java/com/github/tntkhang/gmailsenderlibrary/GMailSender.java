package com.github.tntkhang.gmailsenderlibrary;

public class GMailSender {

    private String email;
    private String pass;
    private static GMailSender instance;
    private String title;
    private String body;
    private String emailAddress;
    private String sender;
    private GmailListener listener;

    private GMailSender(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public static GMailSender withAccount(String username, String pass) {
        instance = new GMailSender(username, pass);
        return instance;
    }

    public GMailSender withTitle(String title) {
        instance.title = title;
        return instance;
    }

    public GMailSender withBody(String body) {
        instance.body = body;
        return instance;
    }

    public GMailSender toEmailAddress(String emailAddress) {
        instance.emailAddress = emailAddress;
        return instance;
    }

    public GMailSender withSender(String sender) {
        instance.sender = sender;
        return instance;
    }

    public GMailSender withListenner(GmailListener listener) {
        instance.listener = listener;
        return instance;
    }

    public void send() {
        try {
            GMailSenderAuthenticator mailSender = new GMailSenderAuthenticator(instance.email, instance.pass, instance.listener);
            mailSender.sendMail(instance.title, instance.body, instance.sender, instance.emailAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
