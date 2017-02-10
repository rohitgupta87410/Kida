package com.espark.adarsh.web.controller.web;

import com.espark.adarsh.annotations.WebMvcController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

@WebMvcController
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Value("${application.message}")
    private String message;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        LOGGER.info("Request Received for Login");
        return new ModelAndView("login");
    }

    @RequestMapping(value="/",method = RequestMethod.GET)
    public ModelAndView welcome(Map<String, Object> model) {
        LOGGER.info("Request Received for welcome page");
        model.put("time", new Date());
        model.put("message", this.message+" "+ System.getProperty("user.name"));
        return new ModelAndView("welcome", model);
    }
}
