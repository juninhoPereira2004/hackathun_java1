package hackathun_java1.hackathun.security;

import hackathun_java1.hackathun.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Prefixo ROLE_ é necessário para Spring Security
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // você pode implementar a lógica de expiração aqui
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // você pode implementar bloqueio aqui
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // pode implementar expiração de credenciais aqui
    }

    @Override
    public boolean isEnabled() {
        return true; // pode implementar habilitação/desabilitação aqui
    }

    public User getUser() {
        return user;
    }
}
