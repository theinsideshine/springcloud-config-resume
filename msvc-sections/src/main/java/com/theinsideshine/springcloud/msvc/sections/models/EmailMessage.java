package com.theinsideshine.springcloud.msvc.sections.models;

public class EmailMessage {

    public String name;
    public String email;

    public String message;

    public EmailMessage(String name, String email, String messaje) {
        this.name = name;
        this.email = email;
        this.message = messaje;
    }

    public EmailMessage() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessaje() {
        return message;
    }

    public void setMessaje(String messaje) {
        this.message = messaje;
    }
}
