package com.ruanazevedo.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ruanazevedo.workshopmongodb.domain.User;
import com.ruanazevedo.workshopmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepo.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User jon = new User(null, "Jon Travolta", "jon@yahoo.com");
		User manu = new User(null, "Manuel Gomes", "bluepen@outlook.com");
		User tog = new User(null, "Toguro", "toguro@outlook.com");
		userRepo.saveAll(Arrays.asList(maria, alex, bob, jon, manu, tog));
	}
}