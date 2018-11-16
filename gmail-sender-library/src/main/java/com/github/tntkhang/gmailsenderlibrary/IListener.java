package com.github.tntkhang.gmailsenderlibrary;

public interface IListener {
    void sendSuccess();
    void sendFail(String err);
}
