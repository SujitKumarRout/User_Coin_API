package com.sujit.UserCoin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sujit.UserCoin.Services.CoinService;

@RestController
@RequestMapping("/coins")
public class CoinController {
	
    @Autowired
    private CoinService coinService;

    @GetMapping("/quotes")
    public ResponseEntity<String> getCoinQuotes(@RequestParam String symbols) {
		return ResponseEntity.ok(coinService.getCoinData(symbols));
    }
}
