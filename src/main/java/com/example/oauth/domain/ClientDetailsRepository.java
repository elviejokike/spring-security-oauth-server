package com.example.oauth.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientDetailsRepository extends JpaRepository<ClientDetailsEntity, UUID> {

	ClientDetailsEntity findByClientId(String clientId);
}
