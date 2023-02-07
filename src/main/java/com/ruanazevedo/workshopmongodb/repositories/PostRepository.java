package com.ruanazevedo.workshopmongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ruanazevedo.workshopmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}