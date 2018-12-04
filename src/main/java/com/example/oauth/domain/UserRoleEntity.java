package com.example.oauth.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
public class UserRoleEntity extends AbstractEntity {

    @Column(name = "user_id", insertable = true, nullable = false)
    private UUID userId;

    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserEntity user;

    @Column(name = "role_id", insertable = true, nullable = false)
    private UUID roleId;

    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private RoleEntity role;

}
