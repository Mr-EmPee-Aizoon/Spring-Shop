package ml.empee.angularShop.model.user;

import lombok.Getter;
import lombok.Setter;
import ml.empee.angularShop.model.roles.Role;

import javax.persistence.*;
import java.util.Set;

@Entity @Getter @Setter
@Table(name = "users")
public class UserEntity {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
