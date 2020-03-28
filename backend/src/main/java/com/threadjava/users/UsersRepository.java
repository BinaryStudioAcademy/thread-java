package com.threadjava.users;

import com.threadjava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}