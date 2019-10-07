package com.springbootsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootsecurity.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUserName(String userName);
}
