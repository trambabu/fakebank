package com.fake.bank.demo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fake.bank.demo.user.role.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
