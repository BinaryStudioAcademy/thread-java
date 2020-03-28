package com.threadjava.auth;

import com.threadjava.models.User;
import com.threadjava.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UsersService userDetailsService;

    @PostMapping("/register")
    public AuthUserDTO signUp(@RequestBody User user) throws Exception {
        return authService.register(user);
    }

    @PostMapping("/login")
    public AuthUserDTO login(@RequestBody UserLoginDTO user) throws Exception {
        return authService.login(user);
    }

    @GetMapping("/user")
    public User getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        var currentUserId = (String)auth.getPrincipal();
        var user = userDetailsService.getUserById(UUID.fromString(currentUserId));
        return user;
    }
}
