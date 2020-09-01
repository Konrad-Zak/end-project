package com.kodilla.endproject.backend.domian;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppUserDto {
    private Long id;
    private String username;
    private String password;
    private String role;

    public AppUserDto(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
