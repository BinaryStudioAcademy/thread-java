package com.threadjava.users;

import com.threadjava.auth.model.AuthUser;
import com.threadjava.users.dto.UserShortDto;
import com.threadjava.users.model.User;
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
        return usersRepository
                .findByEmail(email)
                .map(user -> new AuthUser(user.id, user.email, user.password))
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public UserShortDto getUserById(UUID id) {
        return usersRepository
                .findById(id)
                .map(user -> new UserShortDto(user.id, user.username))
                .orElseThrow(() -> new UsernameNotFoundException("No user found with username"));
    }

    public void save(User user) {
        usersRepository.save(user);
    }
}