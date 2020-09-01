package com.kodilla.endproject.ui.view;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("register")
@CssImport("./style.css")
public class Register extends FormLayout {
    private TextField title = new TextField("Title");
    private TextField author = new TextField("Author");
    private TextField publicationYear = new TextField("Publication year");


    public Register() {
        setResponsiveSteps(
                new ResponsiveStep("10%", 1),
                        new ResponsiveStep("10%", 1),
                        new ResponsiveStep("10%", 1)
        );
        addClassName("form");
        add(title,author,publicationYear);
    }
}
