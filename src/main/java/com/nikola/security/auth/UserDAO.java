package com.nikola.security.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User, String> {

    Optional<User_old> selectApplicationUserByUsername(String username);

}
