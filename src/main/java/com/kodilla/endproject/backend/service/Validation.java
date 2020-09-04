package com.kodilla.endproject.backend.service;


public class Validation {

    private static Validation validation;

    private Validation() {
    }

    public static Validation getInstance() {
        if (validation == null) {
            validation = new Validation();
        }
        return validation;
    }

    public boolean validateTextField(String text){
        return text.length() > 2 & text.length()< 30;
    }

    public boolean validateEmail(String email){
        return email.contains("@");
    }

    public boolean validatePassword(String password){
        return password.length()>4;
    }
}
