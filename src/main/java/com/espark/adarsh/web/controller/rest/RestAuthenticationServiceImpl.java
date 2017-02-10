package com.espark.adarsh.web.controller.rest;

import com.espark.adarsh.bean.ApiServerViewBean;
import com.espark.adarsh.web.security.TokenProvider;
import com.espark.adarsh.persistence.entites.impl.User;
import com.espark.adarsh.web.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Lazy(value = false)
@Scope(value = "singleton")
@RestController
public class RestAuthenticationServiceImpl
 implements RestAuthenticationService{

    private static final Logger logger = LoggerFactory.getLogger(RestAuthenticationServiceImpl.class);

    public static final String LOGIN_URL="/rest/authenticate/login";

    @Autowired(required = true)
    private UserManager userManager;

    @Autowired(required = true)
    private TokenProvider tokenProvider;

    private final String USERNAME = "username";
    private final String PASSWORD = "password";


    // http://localhost:8080/
    @RequestMapping(value = LOGIN_URL, method = RequestMethod.POST)
    public
    @ResponseBody
    ApiServerViewBean authenticateUser(@RequestBody Map<String, String> map, HttpServletResponse httpServletResponse) {
        final ApiServerViewBean apiServer = new ApiServerViewBean();
        logger.debug("Inside-AuthenticationController ");

        final String loginSuccessMsg="LOGIN SUCCESSFUL";
        final String loginFailureMsg="LOGIN UNSUCCESSFUL";


        final String username = map.get(USERNAME);
        final String password = map.get(PASSWORD);

        try {
            final User user = userManager.getUserByName(new User(username));
            if(user!=null){
                if(!user.getUserPwd().equals(password)){
                    throw new BadCredentialsException("Invalid User Credentials ");
                }
               final String token = tokenProvider.getToken(user);
                httpServletResponse.setHeader("Authentication-token", token);
                apiServer.setToken(token);
                apiServer.setUserName(username);
                apiServer.setUserPassword(password);
                apiServer.setMessage(loginSuccessMsg);
                apiServer.setHttpStatus(HttpServletResponse.SC_OK);
            } else {
               throw new RuntimeException("User Not Found ");
            }
            return apiServer;

        } catch (Exception e) {
            logger.error("Exception Generated "+e.getMessage());
            apiServer.setMessage(loginFailureMsg + " - " + e.getMessage());
            apiServer.setHttpStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return apiServer;
        }
    }
}