package com.github.tntkhang.gmailsenderlibrary;

public class GMailSenderHelper {

    private String email;
    private String pass;

    //https://stackoverflow.com/questions/2020088/sending-email-in-android-using-javamail-api-without-using-the-default-built-in-a
    public GMailSenderHelper(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public void sendMail(String title, String body, String emailAddress, IListener listener) {
        try {
            GMailSender mailSender = new GMailSender(email, pass, listener);
            mailSender.sendMail(title, body, "GMailSenderExample", emailAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
