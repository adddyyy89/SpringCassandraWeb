package com.web.cassandra.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.web.cassandra.entity.Credentials;
import com.web.cassandra.repo.CredentialsRepo;

@Component("credentialService")
public class CredentialServiceImpl implements ICredentialService {

	@Override
	public boolean isValid(String username, String password) {
		ClassPathXmlApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext(new ClassPathResource("user-beans.xml").getPath());
			CredentialsRepo repo = context.getBean(CredentialsRepo.class);
			Iterable<Credentials> credentialsItr = repo.findByUsername(username);
			if (null == credentialsItr || null == credentialsItr.iterator()) {
				return false;
			}

			while (credentialsItr.iterator().hasNext()) {
				Credentials credentials = credentialsItr.iterator().next();
				if (credentials.getPassword().equals(password)) {
					return true;
				}
			}

			return false;
		} finally {
			if (null != context) {
				context.close();
			}
		}
	}

}
