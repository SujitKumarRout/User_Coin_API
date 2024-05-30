package com.sujit.UserCoin.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sujit.UserCoin.Models.CoinUser;
import com.sujit.UserCoin.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	 	
	@Autowired
	private UserRepository userRepository;

	@Override
	public CoinUser signUp(CoinUser coinUser) {
		if (userRepository.findByUsername(coinUser.getUsername()).isPresent()
				|| userRepository.findByEmail(coinUser.getEmail()).isPresent()) {
			throw new RuntimeException("Username or email already exists.");
		}
		coinUser.setPassword(new BCryptPasswordEncoder().encode(coinUser.getPassword()));
		return userRepository.save(coinUser);
	}

	@Override
	public CoinUser update(CoinUser coinUser, Long id) {
		CoinUser existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found."));

		if (coinUser.getUsername() != null) {
			existingUser.setUsername(coinUser.getUsername());
		}
		if (coinUser.getPassword() != null) {
			existingUser.setPassword(new BCryptPasswordEncoder().encode(coinUser.getPassword()));
		}
		if (coinUser.getEmail() != null) {
			existingUser.setEmail(coinUser.getEmail());
		}
		if (coinUser.getFirstName() != null) {
			existingUser.setFirstName(coinUser.getFirstName());
		}
		if (coinUser.getLastName() != null) {
			existingUser.setLastName(coinUser.getLastName());
		}
		if (coinUser.getMobile() != null) {
			existingUser.setMobile(coinUser.getMobile());
		}

		return userRepository.save(existingUser);
	}  
}
