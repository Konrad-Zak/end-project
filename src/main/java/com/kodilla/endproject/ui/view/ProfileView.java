package com.kodilla.endproject.ui.view;

import com.kodilla.endproject.ui.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainView.class)
public class ProfileView extends FormLayout {

    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");
    EmailField email = new EmailField("Email");
    Button save = new Button("Save");


    public ProfileView() {
        add(
                firstName,
                lastName,
                email,
                save
        );
    }
}
