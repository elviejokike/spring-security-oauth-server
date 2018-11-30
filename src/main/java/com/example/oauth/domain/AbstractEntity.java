package com.example.oauth.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    public AbstractEntity() {
        this.id = UUID.randomUUID();
    }
}
