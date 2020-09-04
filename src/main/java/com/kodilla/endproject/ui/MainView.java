package com.kodilla.endproject.ui;

import com.kodilla.endproject.backend.domian.PersonDto;
import com.kodilla.endproject.ui.view.DailyCaloricRequirementView;
import com.kodilla.endproject.ui.view.LoginView;
import com.kodilla.endproject.ui.view.MealChoiceView;
import com.kodilla.endproject.ui.view.ProfileView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.NavigationEvent;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;


public class MainView extends AppLayout {

    PersonDto personDto = PersonDto.getInstance();

    public MainView() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("App nutritional plan" + personDto.getUsername());
        logo.addClassName("logo");

        Anchor logout = new Anchor("logout", "Log out");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);
        header.expand(logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassName("header");

        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink profileLink = new RouterLink("Profile", ProfileView.class);
        profileLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
                profileLink,
                new RouterLink("Daily-Caloric-Requirement", DailyCaloricRequirementView.class),
                new RouterLink("Meals", MealChoiceView.class))
        );
    }

}
