package com.threadjava.users;

import com.threadjava.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UsersRepository extends CrudRepository<User, UUID> {
    User findByEmail(String email);
}