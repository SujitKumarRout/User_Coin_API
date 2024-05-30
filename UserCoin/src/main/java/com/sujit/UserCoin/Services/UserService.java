package com.sujit.UserCoin.Services;

import com.sujit.UserCoin.Models.CoinUser;

public interface UserService {

	public CoinUser signUp(CoinUser coinUser);

	public CoinUser update(CoinUser coinUser, Long id);
}
