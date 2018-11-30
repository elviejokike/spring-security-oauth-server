package com.example.oauth.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity extends AbstractEntity {

    private String name;
}
