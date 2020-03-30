package com.threadjava.users;

import com.threadjava.auth.model.AuthUser;
import com.threadjava.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UsersService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public AuthUser loadUserByUsername(String email) throws UsernameNotFoundException {
        var applicationUser = usersRepository.findByEmail(email);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(email);
        }
        return new AuthUser(applicationUser.id, applicationUser.email, applicationUser.password);
    }

    public User getUserById(UUID id) {
        var user = usersRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("No user found with username"));
        user.password = null;
        return user;
    }

    public void save(User user) {
        usersRepository.save(user);
    }
}