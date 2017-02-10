package com.espark.adarsh.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* @see org.springframework.security.core.AuthenticationException
 * @see org.springframework.security.web.authentication.AuthenticationFailureHandler
 *
 * This component provide the functionality for handling the authentication failure event.
 * onAuthenticationFailure() is the callback method executed by framework whent authentication
 * failure event is triggered.
 */
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestAuthenticationFailureHandler.class);
    private static final String MESSAGE="AUTHENTICATION-NOT-SUCCESS";
    /**
     * {@inheritDoc}
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, AuthenticationException authException)
            throws IOException, ServletException {
        LOG.error("On Authentication Failure Exception Occur",authException);
        httpServletResponse.addHeader("MESSAGE",MESSAGE);
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Bad credentials");
    }
}