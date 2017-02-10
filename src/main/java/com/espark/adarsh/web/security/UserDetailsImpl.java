package com.espark.adarsh.web.security;

import com.espark.adarsh.persistence.entites.impl.UserRole;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl extends User implements UserDetails {

    public UserDetailsImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserDetailsImpl(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    private com.espark.adarsh.persistence.entites.impl.User user;


    public com.espark.adarsh.persistence.entites.impl.User getUser() {
        return user;
    }

    public void setUser(com.espark.adarsh.persistence.entites.impl.User user) {
        this.user = user;
    }

    public String getRole() {
        return user.getUserRoles().iterator().next().getName();
    }


    @Override
    public String toString() {
        return "UserDetailsImpl{" +
                "user=" + user +
                '}';
    }
}

