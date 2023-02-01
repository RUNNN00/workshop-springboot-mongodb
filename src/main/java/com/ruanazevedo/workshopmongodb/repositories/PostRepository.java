package com.ruanazevedo.workshopmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ruanazevedo.workshopmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {}