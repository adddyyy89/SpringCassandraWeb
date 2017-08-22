package com.web.cassandra.service;

import org.springframework.stereotype.Component;


public interface ICredentialService {
	public boolean isValid(String username, String password);
}
