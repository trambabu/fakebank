package com.fake.bank.demo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fake.bank.demo.user.role.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByName(String name);

}
