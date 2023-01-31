package com.ruanazevedo.workshopmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ruanazevedo.workshopmongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	
}
