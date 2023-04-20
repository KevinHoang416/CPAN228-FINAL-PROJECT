package com.example.clotheswarehouse.model.form;

import com.example.clotheswarehouse.model.User;

import lombok.Data;

@Data
public class RegistrationForm {
    private String username;
    private String password;

    public User toUser() {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }

}
