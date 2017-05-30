package com.fly.heart.utils;

import java.io.Serializable;

/**
 * created by tanghuosong 2017/5/30
 * description: 返回操作结果类
 **/
public class Message implements Serializable{

    private String content;
    private boolean success;

    public Message() {
    }

    public Message(String content, boolean success) {
        this.content = content;
        this.success = success;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
