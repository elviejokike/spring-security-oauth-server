package com.example.oauth.service;

import com.example.oauth.domain.UserEntity;
import com.example.oauth.domain.UserRepository;
import com.example.oauth.domain.UserRoleEntity;
import com.example.oauth.domain.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	private final UserRoleRepository userRoleRepository;

	@Autowired
	public CustomUserDetailsService(
			UserRepository userRepository,
			UserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username);
		if (null == user) {
			throw new UsernameNotFoundException(
					"INVALID USER WITH LOGIN: " + username);
		} else {

			List<UserRoleEntity> userRoles = userRoleRepository.findRoleByUserId(user.getId());

			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			if (userRoles != null && !userRoles.isEmpty()) {
				for (UserRoleEntity role : userRoles) {
					grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().getName()));
				}
			}

			return new CustomUserDetails(user.getUsername(), user.getPassword(), grantedAuthorities);
		}
	}
}
