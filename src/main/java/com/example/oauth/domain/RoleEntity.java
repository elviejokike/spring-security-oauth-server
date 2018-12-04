package com.example.oauth.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity(name = "roles")
@Table
@Getter
@Setter
public class RoleEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;
}
