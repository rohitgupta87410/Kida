package com.espark.adarsh.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* @see  org.springframework.security.core.AuthenticationException
 * @see org.springframework.security.web.AuthenticationEntryPoint
 *
 * This class provide a entry point for the all the incomming request to the api server
 * other then which is configured for not to intercept from spring security
 */
public class ApiServerAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static Logger LOG = LoggerFactory.getLogger(ApiServerAuthenticationEntryPoint.class);
    private static final String MESSAGE="MESSAGE";
    private static final String NOT_AUTHENTICATED_ACCESS_DENIED ="NOT-AUTHENTICATED-ACCESS-DENIED";

    /**
     * {@inheritDoc}
     */
    @Override
    public void commence(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, AuthenticationException authException)
            throws IOException, ServletException {
        LOG.debug("Entering into Security Area "+ httpServletRequest.getRequestURI()+" "+ httpServletRequest.getQueryString()+" "+ httpServletRequest.getRequestURL());
        httpServletResponse.addHeader(MESSAGE, NOT_AUTHENTICATED_ACCESS_DENIED);
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}
