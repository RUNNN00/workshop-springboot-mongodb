package com.ruanazevedo.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruanazevedo.workshopmongodb.domain.User;
import com.ruanazevedo.workshopmongodb.dto.UserDTO;
import com.ruanazevedo.workshopmongodb.repositories.UserRepository;
import com.ruanazevedo.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException());
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id); // verifica se o objeto existe
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = repository.findById(obj.getId()).get();
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	private void updateData(User user, User obj) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
	}
}
