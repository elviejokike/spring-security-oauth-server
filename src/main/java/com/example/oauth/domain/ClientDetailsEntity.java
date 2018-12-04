package com.example.oauth.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "client_details")
@Table
@Getter
@Setter
public class ClientDetailsEntity extends AbstractEntity {

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "resource_ids")
    private String resourceIds;

    @Column(name = "scope")
    private String scope;

    @Column(name = "grant_types")
    private String grantTypes;

    @Column(name = "redirect_url")
    private String redirectUrl;

    @Column(name = "authorities")
    private String authorities;

    @Column(name = "access_token_validity")
    private int accessTokenValidity;

    @Column(name = "refresh_token_validity")
    private int refreshTokenValidity;

    @Column(name = "description")
    private String description;



}
