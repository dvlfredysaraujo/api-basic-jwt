package com.cardatabase.demo.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class AccountCredentials {
    private String username;
    private String password;

}
