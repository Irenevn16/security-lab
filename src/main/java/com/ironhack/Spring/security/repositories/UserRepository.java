package com.ironhack.Spring.security.repositories;

import com.ironhack.Spring.security.models.ERole;
import com.ironhack.Spring.security.models.Role;
import com.ironhack.Spring.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

