package org.torquemada.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="role_name")
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
