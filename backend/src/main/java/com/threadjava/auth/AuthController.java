package com.threadjava.auth;

import com.threadjava.auth.dto.*;
import com.threadjava.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UsersService userDetailsService;

    @PostMapping("/register")
    public AuthUserDTO signUp(@RequestBody UserRegisterDto user) throws Exception {
        return authService.register(user);
    }

    @PostMapping("/login")
    public AuthUserDTO login(@RequestBody UserLoginDTO user) throws Exception {
        return authService.login(user);
    }
}
