package com.espark.adarsh.web.security;

import com.espark.adarsh.persistence.entites.impl.User;
import com.espark.adarsh.persistence.entites.impl.UserRole;
import com.espark.adarsh.web.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

public class RestApiAuthProvider  implements AuthenticationProvider{

    private static final Logger LOG = LoggerFactory.getLogger(RestApiAuthProvider.class);

    @Qualifier("userManagerImpl")
    @Autowired(required = true)
    private UserManager userManager;


    @Override
    @Transactional(readOnly = true)
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        LOG.debug("RestApiAuthProvider retrieveUser() ");
        final String username=authentication.getName();
        final String userPassword=authentication.getCredentials().toString();
        try {
            User bean = new User(username);
            bean = userManager.getUser(bean);
            userManager.updateUser(bean);
            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(bean.getUserRoles().size());
            for (UserRole role : bean.getUserRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            return new UsernamePasswordAuthenticationToken(username, userPassword,
                    authorities);

        } catch (Exception e) {
            LOG.error("Unable to find record with username:=" + username, e);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
