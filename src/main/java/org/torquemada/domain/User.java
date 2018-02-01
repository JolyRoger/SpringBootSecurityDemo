package org.torquemada.domain;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> authorities;
    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
