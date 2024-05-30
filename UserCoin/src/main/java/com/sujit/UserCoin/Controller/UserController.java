package com.sujit.UserCoin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujit.UserCoin.Models.CoinUser;
import com.sujit.UserCoin.Services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    
	@Autowired
    private UserService userService;

    @PutMapping("/update/{id}")
    public ResponseEntity<CoinUser> update(@RequestBody CoinUser coinUser, @PathVariable Long id) {
        return ResponseEntity.ok(userService.update(coinUser, id));
    }
    

    @PostMapping("/signUp")
    public ResponseEntity<CoinUser> signUp(@Valid @RequestBody CoinUser coinUser) {
        if (!isValidPassword(coinUser.getPassword())) {
            return ResponseEntity.badRequest().build();
        }
        String hashedPassword = new BCryptPasswordEncoder().encode(coinUser.getPassword());

        coinUser.setPassword(hashedPassword);

        CoinUser savedUser = userService.signUp(coinUser);

        return ResponseEntity.ok(savedUser);
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 && password.length() <= 15;
    }
}
