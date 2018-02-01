package org.torquemada.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.torquemada.domain.Role;

@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return User.withDefaultPasswordEncoder().
               username("user").
               password("password").
               roles(String.valueOf(Role.USER)).
               accountExpired(false).
               accountLocked(false).
               credentialsExpired(false).
               disabled(false).build();
    }
}
