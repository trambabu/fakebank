package com.fake.bank.demo.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fake.bank.demo.model.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
	
//	UserProfile findByEmailAddress(String paramString);
	  
	UserProfile findBySsn(String paramString);
	  
	List<UserProfile> findAll();

}
