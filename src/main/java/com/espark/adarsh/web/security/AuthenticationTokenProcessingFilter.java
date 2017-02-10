package com.espark.adarsh.web.security;

import com.espark.adarsh.persistence.entites.impl.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

    private static Logger LOG = LoggerFactory.getLogger(AuthenticationTokenProcessingFilter.class);

    @Autowired(required = true)
    private TokenProvider tokenProvider;

    private TokenService tokenService;

    @Autowired(required = true)
    private AuthenticationManager authenticationManager;

    private SecurityContextProvider securityContextProvider  = new SecurityContextProvider();

    private WebAuthenticationDetailsSource webAuthenticationDetailsSource = new WebAuthenticationDetailsSource();

    public AuthenticationTokenProcessingFilter(AuthenticationManager authenticationManager,final TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService=tokenService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        LOG.debug("Checking headers and parameters for authentication token...");

        String token = null;

        final HttpServletRequest httpServletRequest = this.asHttpServletRequest(request);
        if (httpServletRequest.getHeader("Authentication-token") != null) {
            token = httpServletRequest.getHeader("Authentication-token");
            LOG.debug("Found token '" + token + "' in request headers");
        }

        if (token != null) {
            if(this.tokenService.contains(token)){
                final SecurityContext securityContext = this.securityContextProvider.getSecurityContext();
                securityContext.setAuthentication(this.tokenService.retrieve(token));
            }else if (tokenProvider.isTokenValid(token)) {
                final User user = tokenProvider.getUserFromToken(token);
                LOG.debug("Inside-AuthenticationTokenProcessingFilter.java");
                this.authenticateUser(httpServletRequest, user,token);
            }
        }
        chain.doFilter(request, response);
    }

    private HttpServletRequest asHttpServletRequest(ServletRequest servletRequest){
        return (HttpServletRequest)servletRequest;
    }

    private HttpServletResponse asHttpServletResponse(ServletResponse servletResponse){
        return (HttpServletResponse)servletResponse;
    }

    private void authenticateUser(HttpServletRequest request, User user,String token) {
        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getUserPwd());
        authenticationToken.setDetails(this.webAuthenticationDetailsSource.buildDetails(request));
        final SecurityContext securityContext = this.securityContextProvider.getSecurityContext();
        final Authentication authentication=this.authenticationManager.authenticate(authenticationToken);
        securityContext.setAuthentication(authentication);
        this.tokenService.store(token,authentication);
    }
}
