package com.madura.spring.user.registration.and.login.repository;

import com.madura.spring.user.registration.and.login.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
