package com.sujit.UserCoin.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sujit.UserCoin.Models.CoinUser;

public interface UserRepository extends JpaRepository<CoinUser, Long>{
	Optional<CoinUser> findByUsername(String username);

	Optional<CoinUser> findByEmail(String email);
}
