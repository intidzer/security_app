package com.nikola.security.auth;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAORepository implements UserDAO{

    @Override
    @Query("SELECT user FROM User user WHERE username = ?1")
    public Optional<User_old> selectApplicationUserByUsername(String username) {
        return Optional.empty();
    }
}
