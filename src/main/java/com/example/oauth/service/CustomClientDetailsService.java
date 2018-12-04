package com.example.oauth.service;

import com.example.oauth.domain.ClientDetailsEntity;
import com.example.oauth.domain.ClientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;

@Service
public class CustomClientDetailsService implements ClientDetailsService {

    private final ClientDetailsRepository clientDetailsRepository;

    @Autowired
    public CustomClientDetailsService(ClientDetailsRepository clientDetailsRepository) {
        this.clientDetailsRepository = clientDetailsRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientDetailsEntity entity = clientDetailsRepository.findByClientId(clientId);
        if (entity == null) {
            throw new NoSuchClientException("Client not found " + clientId);
        }
        return new CustomClientDetails(entity);
    }
}
