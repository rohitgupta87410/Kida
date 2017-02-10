package com.espark.adarsh.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/* @see org.springframework.security.access.AccessDeniedException
 * @see org.springframework.security.web.access.AccessDeniedHandler
 *
 * This class provide the implementation for Access Denied Handler handle()
 * is the callback method which will executed when any protected resource is
 * access without sufficent privillage.
 */
public class RestAccessDeniedHandler implements
        org.springframework.security.web.access.AccessDeniedHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestAccessDeniedHandler.class);
    private static final String MESSAGE="ACCESS-DENIED-LACK-OF-PERMISSIONS";

    /**
     * {@inheritDoc}
     */
    @Override
    public void handle(HttpServletRequest request
            , HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        LOG.error("RestAccessDeniedHandler ", accessDeniedException);
        response.addHeader("MESSAGE", MESSAGE);
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "ACCESS-DENIED");
    }
}
