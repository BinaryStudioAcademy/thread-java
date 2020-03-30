package com.threadjava.auth;

import com.threadjava.auth.model.AuthUser;
import com.threadjava.auth.model.AuthUserDTO;
import com.threadjava.auth.model.UserLoginDTO;
import com.threadjava.models.User;
import com.threadjava.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsersService userDetailsService;

    public AuthUserDTO register(User user) throws Exception {
        var loginDTO= new UserLoginDTO();
        loginDTO.password = user.password;
        loginDTO.email = user.email;
        user.password = bCryptPasswordEncoder.encode(user.password);
        userDetailsService.save(user);
        return login(loginDTO);
    }

    public AuthUserDTO login(UserLoginDTO user) throws Exception {
        Authentication auth;
        try {
            auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.email, user.password));
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        var currentUser = (AuthUser)auth.getPrincipal();

        final var userDetails = userDetailsService.getUserById(currentUser.id);

        final String jwt = tokenService.generateToken(currentUser);

        var result = new AuthUserDTO();
        result.user = userDetails;
        result.token = jwt;
        return result;
    }
}