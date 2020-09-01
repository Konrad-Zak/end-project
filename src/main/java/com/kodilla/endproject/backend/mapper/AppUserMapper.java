package com.kodilla.endproject.backend.mapper;

import com.kodilla.endproject.backend.domian.AppUser;
import com.kodilla.endproject.backend.domian.AppUserDto;
import org.springframework.stereotype.Component;

@Component
public class AppUserMapper {

    public AppUser mapToAppUser(final AppUserDto appUserDto){
        return new AppUser(
                appUserDto.getId(),appUserDto.getUsername(),appUserDto.getPassword(),appUserDto.getRole());
    }

    public AppUserDto mapToAppUserDto(final AppUser appUser){
        return new AppUserDto(
                appUser.getId(),appUser.getUsername(),appUser.getPassword(),appUser.getRole()
        );
    }
}
