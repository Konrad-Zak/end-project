package com.kodilla.endproject.backend;

import com.kodilla.endproject.backend.domian.AppUser;
import com.kodilla.endproject.backend.domian.AppUserDto;
import com.kodilla.endproject.backend.mapper.AppUserMapper;
import com.kodilla.endproject.backend.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class start {

    private AppUserRepository appUserRepository;
    private AppUserMapper appUserMapper;
    private PasswordEncoder passwordEncoder;

    public start(AppUserRepository appUserRepository, AppUserMapper appUserMapper, PasswordEncoder passwordEncoder ) {
        this.appUserRepository = appUserRepository;
        this.appUserMapper = appUserMapper;

        AppUserDto appUserDto = new AppUserDto("Roman",passwordEncoder.encode("Roman"),"ADMIN");
        appUserRepository.save(appUserMapper.mapToAppUser(appUserDto));
    }



}
