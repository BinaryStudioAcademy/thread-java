package com.threadjava.users;

import com.threadjava.auth.model.AuthUser;
import com.threadjava.users.dto.UserDetailsDto;
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
                .map(user -> new AuthUser(user.getId(), user.getEmail(), user.getPassword()))
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public UserDetailsDto getUserById(UUID id) {
        return usersRepository
                .findById(id)
                .map(user -> UserMapper.MAPPER.userToUserDetailsDto(user))
                .orElseThrow(() -> new UsernameNotFoundException("No user found with username"));
    }

    public void save(User user) {
        usersRepository.save(user);
    }
}