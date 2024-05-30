package com.sujit.UserCoin.Services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinServiceImpl implements CoinService {

	private static final String API_KEY = "27ab17d1-215f-49e5-9ca4-afd48810c149";
	private static final String API_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest";

	@Override
	public String getCoinData(String symbols) {
		RestTemplate restTemplate = new RestTemplate();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("X-CMC_PRO_API_KEY", API_KEY);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(API_URL + "?symbol=" + symbols, HttpMethod.GET, entity,
				String.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			throw new RuntimeException("Failed to fetch coin data");
		}
	}
}
