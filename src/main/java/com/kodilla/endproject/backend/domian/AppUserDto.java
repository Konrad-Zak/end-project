package com.kodilla.endproject.backend.domian;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {
    private static final String DEFAULT_ROLE = "USER";
    private Long id;

    private String username;
    private String password;
    private String role;


    public AppUserDto(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public AppUserDto(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = DEFAULT_ROLE;
    }


}
