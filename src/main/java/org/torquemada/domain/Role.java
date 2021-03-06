package org.torquemada.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="roles")
public class Role implements GrantedAuthority {

    public Role(String authority) {
        this.authority = authority;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "role_id_fk"), inverseJoinColumns = @JoinColumn(name = "user_id_fk"))
    private List<User> user;

    @Column(name="role_name")
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }

    /*
       To avoid StackOverflowError when user and role infinitely print each other
     */
    @Override
    public String toString() {
        return id + "::" + authority;
    }
}
