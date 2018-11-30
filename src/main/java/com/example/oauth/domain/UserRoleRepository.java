package com.example.oauth.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {

    List<UserRoleEntity> findRoleByUserId(UUID userId);

}