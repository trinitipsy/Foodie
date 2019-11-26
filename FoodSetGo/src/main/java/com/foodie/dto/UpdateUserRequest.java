package com.foodie.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class UpdateUserRequest {
    private String name;
    private String surname;
    private String address;
    @Email
    private String email;
    private String password;
}
