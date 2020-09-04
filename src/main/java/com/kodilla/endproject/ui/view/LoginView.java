package com.kodilla.endproject.ui.view;

import com.kodilla.endproject.backend.domian.AppUserDto;
import com.kodilla.endproject.backend.domian.PersonDto;
import com.kodilla.endproject.backend.mapper.AppUserMapper;
import com.kodilla.endproject.backend.repository.AppUserRepository;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;


@Route("login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private LoginForm login = new LoginForm();
    private Register register = new Register();
    private LoginI18n loginI18n = LoginI18n.createDefault();
    private PersonDto personDto = PersonDto.getInstance();
    private AppUserRepository appUserRepository;
    private AppUserMapper appUserMapper;

    public LoginView(AppUserRepository appUserRepository, AppUserMapper appUserMapper){
        this.appUserMapper = appUserMapper;
        this.appUserRepository = appUserRepository;
        prepareLoginForm();
        add(new H1("App nutritional plan"),login , register);
        login.addForgotPasswordListener(event -> {
            register.setVisible(true);
            login.setVisible(false);
        });
        register.getButton().addClickListener(event -> {
            save();
            register.setVisible(false);
            login.setVisible(true);
        });
        login.addLoginListener(event -> {
            personDto.setUsername(event.getUsername());
        });

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // inform the user about an authentication error
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }
    private void save() {
        AppUserDto appUserDto = new AppUserDto(register.getUsername().getValue(),register.getPassword().getValue());
        appUserRepository.save(appUserMapper.mapToAppUser(appUserDto));
    }

    private void prepareLoginForm(){
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        login.setI18n(loginI18n);
        loginI18n.getForm().setForgotPassword("Register");
        login.setAction("login");
        register.setVisible(false);
    }

}
