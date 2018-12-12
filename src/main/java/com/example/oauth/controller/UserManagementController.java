package com.example.oauth.controller;

import com.example.oauth.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(path = "/users")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserManagementController {

	private final UserManagementService userManagementService;

	@GetMapping
	public ResponseEntity simpleGet(){
		return ResponseEntity.ok().build();
	}
}
