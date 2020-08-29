package com.kodilla.endproject;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    PasswordField passwordField = new PasswordField();
    String password;
    Button button = new Button("Text");



    public MainView() {
        passwordField.setLabel("Password");
        passwordField.setPlaceholder("Enter password");
        passwordField.setValue("secret1");
        password = passwordField.getValue();
        button.addClickListener(event ->{
            password = passwordField.getValue();
            System.out.println(password);
        });
        add(passwordField,button);

    }
}
