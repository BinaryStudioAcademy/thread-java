package com.threadjava.auth.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

import java.util.UUID;

import static java.util.Collections.emptyList;

public class AuthUser extends User {
    public AuthUser(UUID id, String username, String password) {
        super(username, password, emptyList());
        this.id = id;
    }

    public AuthUser(UUID id, String username) {
        super(username, null, emptyList());
        this.id = id;
    }

    @Getter @Setter private UUID id;
}
