package com.example.oauth.service;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {

    public CustomUserDetails(String userName, String password, Collection<? extends GrantedAuthority> authorities) {
        super(userName, password, authorities);
    }

}
