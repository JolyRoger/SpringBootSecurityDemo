package org.torquemada.domain;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import java.util.List;

//@Entity
@Data
public class User implements UserDetails {
    private List<Role> authorities;
    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
