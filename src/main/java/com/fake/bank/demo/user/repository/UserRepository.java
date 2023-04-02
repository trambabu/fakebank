package com.fake.bank.demo.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fake.bank.demo.user.Users;

@Repository
//public interface UserRepository extends JpaRepository<User, Integer> {
public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String paramString);
	
//  Optional<User> findByEmail(String email);
	 Optional<Users> findByEmail(String username);
	  
	List<Users> findAll();
}
