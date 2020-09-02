package com.kodilla.endproject.ui.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;

import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import com.vaadin.flow.router.Route;



@Route("register")
@CssImport("./style.css")
public class Register extends FormLayout {

    private TextField username = new TextField("Login");
    private PasswordField password = new PasswordField("Password");
    private Button button = new Button("Register");



    public Register() {
        addClassName("form");
        setResponsiveSteps(
                new ResponsiveStep("10%", 1),
                new ResponsiveStep("10%", 1));
        add(username, password, button);
    }

    public Button getButton() {
        return button;
    }

    public TextField getUsername() {
        return username;
    }

    public PasswordField getPassword() {
        return password;
    }
}
