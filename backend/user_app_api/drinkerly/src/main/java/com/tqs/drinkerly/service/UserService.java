package com.tqs.drinkerly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {
    
    private static UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        UserService.userRepository = userRepository;
    }
    
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

	public User getUserById(long id){
		return userRepository.findById(id).get();
	}

	public User getUserByEmail(String email){
		return userRepository.findByEmail(email);
	}

	public ResponseEntity<Void> deleteUserById(long id){

		User user = userRepository.findById(id).get();

		userRepository.delete(user);
		
		return ResponseEntity.noContent().build();
	}

    public User updateUserFirstNameById(long id, String firstName) {

		Optional<User> OpUser = userRepository.findById(id);
		User user = OpUser.get();
				
		if (user.getFirstName() != null) {
			user.setFirstName(firstName);
		}

		return userRepository.save(user);
	}

    public User updateUserLastNameById(long id, String lastName) {

		User user = userRepository.findById(id).get();
				
		if (user.getLastName() != null) {
			user.setLastName(lastName);
		}

		return userRepository.save(user);
	}

    public User updateUserPasswordById(long id, String password) {

		User user = userRepository.findById(id).get();
				
		if (user.getPassword() != null) {
			user.setPassword(password);
		}

		return userRepository.save(user);
	}

    public User updateUserEmailById(long id, String email) {

		User user = userRepository.findById(id).get();
				
		if (user.getEmail() != null) {
			user.setEmail(email);
		}

		return userRepository.save(user);
	}

    public User updateUserAddressById(long id, String address) {

		User user = userRepository.findById(id).get();
				
		if (user.getAddress() != null) {
			user.setAddress(address);
		}

		return userRepository.save(user);
	}

    public User updateUserPhoneById(long id, String phone) {

		User user = userRepository.findById(id).get();
				
		if (user.getPhone() != null) {
			user.setPhone(phone);
		}

		return userRepository.save(user);
	}

    public User updateUserAgeById(long id, int age) {

		User user = userRepository.findById(id).get();
				
		if (user.getAge() != 0) {
			user.setAge(age);
		}

		return userRepository.save(user);
	}

    public User updateUserNifById(long id, int nif) {

		User user = userRepository.findById(id).get();
				
		if (user.getNif() != 0) {
			user.setNif(nif);
		}

		return userRepository.save(user);
	}


}
