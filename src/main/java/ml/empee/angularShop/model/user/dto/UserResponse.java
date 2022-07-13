package ml.empee.angularShop.model.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import ml.empee.angularShop.model.CommonDTO;
import ml.empee.angularShop.model.roles.Role;
import ml.empee.angularShop.model.user.UserEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Getter @Setter
public class UserResponse extends CommonDTO<UserEntity, UserResponse> implements UserDetails {

    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private Set<Role> roles;
    @JsonIgnore
    private Collection<? extends GrantedAuthority> authorities;

    public UsernamePasswordAuthenticationToken wrapIntoAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(this, password, authorities);
    }

    public void setRoles(Set<Role> roles) {
        this.roles = Collections.unmodifiableSet(roles);
        authorities = roles.stream().map(
                role -> new SimpleGrantedAuthority(role.getName())
        ).toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
