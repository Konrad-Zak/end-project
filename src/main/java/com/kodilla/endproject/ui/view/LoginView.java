package com.kodilla.endproject.ui.view;

import com.kodilla.endproject.backend.domian.AppUserDto;
import com.kodilla.endproject.backend.mapper.AppUserMapper;
import com.kodilla.endproject.backend.repository.AppUserRepository;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import org.springframework.security.crypto.password.PasswordEncoder;

@Route("login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private LoginForm login = new LoginForm();
    private Register register = new Register();
    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;

    public LoginView(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.appUserRepository = appUserRepository;
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        //setJustifyContentMode(JustifyContentMode.CENTER);

        login.setAction("login");
        register.setVisible(false);
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
        AppUserDto appUserDto = new AppUserDto(register.getUsername().getValue(),
                passwordEncoder.encode(register.getPassword().getValue()));
        appUserRepository.save(AppUserMapper.getInstance().mapToAppUser(appUserDto));
    }

}
