package com.threadjava.auth;

import com.threadjava.auth.model.AuthUserDTO;
import com.threadjava.auth.model.UserLoginDTO;
import com.threadjava.models.User;
import com.threadjava.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static com.threadjava.auth.TokenService.getUserId;

@RestController
@RequestMapping("/api/auth")
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
        var user = userDetailsService.getUserById(getUserId());
        return user;
    }
}
