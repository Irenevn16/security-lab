package com.ironhack.Spring.security.repositories;


import com.ironhack.Spring.security.models.ERole;
import com.ironhack.Spring.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

