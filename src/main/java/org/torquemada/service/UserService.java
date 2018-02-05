package org.torquemada.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.torquemada.domain.Role;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.torquemada.domain.User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username + "not found"));
        String[] roles = user.getAuthorities().stream().map(Role::getAuthority).toArray(String[]::new);

        return User.withDefaultPasswordEncoder().
            username(user.getUsername()).
            password(user.getPassword()).
            roles(roles).
            accountExpired(!user.isAccountNonExpired()).
            accountLocked(!user.isAccountNonLocked()).
            credentialsExpired(!user.isCredentialsNonExpired()).
            disabled(!user.isEnabled()).build();
    }
}
