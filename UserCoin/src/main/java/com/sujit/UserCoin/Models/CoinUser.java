package com.sujit.UserCoin.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class CoinUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Username is mandatory")
	@Size(min = 4, max = 15, message = "Username must be between 4 and 15 characters")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username must contain only alphanumeric characters")
	@Column(nullable = false, unique = true)
	private String username;

	@NotBlank(message = "Password is mandatory")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
	@Column(nullable = false)
	private String password;

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	@Column(nullable = false, unique = true)
	private String email;

	private String firstName;
	private String lastName;
	private String mobile;

}
