package com.qlnsitsol.demo.messager;

public class Messager {
    private String message;
    public Messager() {

    }
    public Messager(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
