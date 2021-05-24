package com.app.config;

public class ErrorFormat {
    private String campo;
    private String message;

    public String getCampo() {
        return this.campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorFormat(String campo, String message) {
        this.campo = campo;
        this.message = message;
    }

    public ErrorFormat() {
    }
}
