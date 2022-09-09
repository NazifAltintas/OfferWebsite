package com.atom_v1.repository;

import com.atom_v1.data.Address;
import com.atom_v1.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByEmail(String email);
}
