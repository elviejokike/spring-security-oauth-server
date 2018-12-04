package com.example.oauth.api;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public abstract class Resource {
	private UUID id;
}
