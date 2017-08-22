package com.web.cassandra.repo;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.cassandra.entity.Credentials;

@Repository
public interface CredentialsRepo extends CrudRepository<Credentials, String> {

	@Query("select * from credentials where username = ?0")
	Iterable<Credentials> findByUsername(String username);

	@Query("select * from credentials where username = ?0 and password=?1")
	Iterable<Credentials> findByUsernameAndPassword(String username, String password);
}
