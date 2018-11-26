package com.github.tntkhang.gmailsenderlibrary;

public interface GmailListener {
    void sendSuccess();
    void sendFail(String err);
}
