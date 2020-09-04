package com.kodilla.endproject.backend.domian;


public class PersonDto {

    private static PersonDto personDto;

    private String username;

    private PersonDto(){
    }

    public static PersonDto getInstance() {
        if (personDto == null) {
            personDto = new PersonDto();
        }
        return personDto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
