package com.example.mybot;

import java.io.Serializable;
import java.util.Date;
public class Message implements Serializable {
    private String msgServer;
    private String msgClient;
    private Date msgDate;

    public Message(Date msgDate, String msgServer, String msgClient) {
        this.msgDate = msgDate;
        this.msgServer = msgServer;
        this.msgClient = msgClient;
    }

    public String getMsgServer() {
        return msgServer;
    }

    public String getMsgClient() {
        return msgClient;
    }

    public Date getMsgDate() {
        return msgDate;
    }

}
