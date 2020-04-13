package com.threadjava.users;

import com.threadjava.users.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends CrudRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}