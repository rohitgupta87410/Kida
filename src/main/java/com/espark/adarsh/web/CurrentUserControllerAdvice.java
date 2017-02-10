package com.espark.adarsh.web;

import com.espark.adarsh.annotations.WebMvcController;
import com.espark.adarsh.web.controller.web.LoginController;
import com.espark.adarsh.web.controller.web.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(assignableTypes  = {LoginController.class, UserController.class})
public class CurrentUserControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserControllerAdvice.class);

   @ModelAttribute("currentUser")
    public UserDetails getCurrentUser(Authentication authentication) {
       try{
        return (authentication == null  ? null : (UserDetails) authentication.getPrincipal());
       }catch (Exception e){
           LOGGER.error("Exception "+e.getLocalizedMessage());
       }
       return null;
    }

}
