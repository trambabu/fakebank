package com.fake.bank.demo.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fake.bank.demo.config.JwtService;
import com.fake.bank.demo.dto.AccountRegisterRequest;
import com.fake.bank.demo.token.Token;
import com.fake.bank.demo.token.TokenRepository;
import com.fake.bank.demo.token.TokenType;
import com.fake.bank.demo.user.Users;
import com.fake.bank.demo.user.repository.UserRepository;
import com.fake.bank.demo.user.role.Role;
import com.fake.bank.demo.user.role.UserRole;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	private final UserRepository repository;
	private final TokenRepository tokenRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

//  public AuthenticationResponse register(RegisterRequest request) {
//    var user = User.builder()
//        .firstname(request.getFirstname())
//        .lastname(request.getLastname())
//        .email(request.getEmail())
//        .password(passwordEncoder.encode(request.getPassword()))
//        .role(Role.USER)
//        .build();
//    var savedUser = repository.save(user);
//    var jwtToken = jwtService.generateToken(user);
//    saveUserToken(savedUser, jwtToken);
//    return AuthenticationResponse.builder()
//        .token(jwtToken)
//        .build();
//  }
	public AuthenticationResponse register(AccountRegisterRequest request) {
		var user = Users.builder()
//	        .firstname(request.getFirstname())
//	        .lastname(request.getLastname())
				.email(request.getEmail()).username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword()))
//	        .role(Role.USER)
//	        .userRoles(UserRole)
				.build();
		var savedUser = repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		saveUserToken(savedUser, jwtToken);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		var user = repository.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		revokeAllUserTokens(user);
		saveUserToken(user, jwtToken);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

//  private void saveUserToken(User user, String jwtToken) {
//    var token = Token.builder()
//        .user(user)
//        .token(jwtToken)
//        .tokenType(TokenType.BEARER)
//        .expired(false)
//        .revoked(false)
//        .build();
//    tokenRepository.save(token);
//  }

	private void saveUserToken(Users user, String jwtToken) {
		var token = Token.builder().users(user).token(jwtToken).tokenType(TokenType.BEARER).expired(false)
				.revoked(false).build();
		tokenRepository.save(token);
	}

//  private void revokeAllUserTokens(User user) {
//    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
//    if (validUserTokens.isEmpty())
//      return;
//    validUserTokens.forEach(token -> {
//      token.setExpired(true);
//      token.setRevoked(true);
//    });
//    tokenRepository.saveAll(validUserTokens);
//  }
	private void revokeAllUserTokens(Users user) {
		var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
		if (validUserTokens.isEmpty())
			return;
		validUserTokens.forEach(token -> {
			token.setExpired(true);
			token.setRevoked(true);
		});
		tokenRepository.saveAll(validUserTokens);
	}
	
	
}
