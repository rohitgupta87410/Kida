package com.espark.adarsh.web.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
/* @see org.springframework.security.core.context.SecurityContext;
 * @see org.springframework.security.core.context.SecurityContextHolder;
 *
 * This component provide the functionality for getting the spring security context
 *
 */
public class SecurityContextProvider {

    /**
     * getSecurityContext() provide the functionality of
     * retrieving the current spring security instance.
     * @return the current instance of the SecurityContext
     */
    public SecurityContext getSecurityContext() {
        return SecurityContextHolder.getContext();
    }

    /**
     * getUserDetails() provide the UserDetails instance.
     * @return
     */
    public String getUserDetails(){
        return this.getSecurityContext().getAuthentication().getPrincipal().toString();
    }

}