package com.example.oauth.service;

import com.example.oauth.domain.ClientDetailsEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CustomClientDetails implements ClientDetails {

	private final ClientDetailsEntity clientDetails;

	public CustomClientDetails(ClientDetailsEntity clientDetails) {
		this.clientDetails = clientDetails;
	}

	@Override
	public String getClientId() {
		return clientDetails.getClientId();
	}

	@Override
	public Set<String> getResourceIds() {
		return null;
	}

	@Override
	public boolean isSecretRequired() {
		return false;
	}

	@Override
	public String getClientSecret() {
		return clientDetails.getClientSecret();
	}

	@Override
	public boolean isScoped() {
		return clientDetails.getScope() != null;
	}

	@Override
	public Set<String> getScope() {
		return null;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return null;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return null;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return null;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return false;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return null;
	}
}
