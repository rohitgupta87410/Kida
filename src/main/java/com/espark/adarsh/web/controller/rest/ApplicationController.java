package com.espark.adarsh.web.controller.rest;

import com.espark.adarsh.bean.ResponseBean;
import com.espark.adarsh.web.security.SecurityContextProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ApplicationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);

    public static final String WELCOME_URL="/rest/welcome";

    @Value("${application.message}")
    private String message;

    private SecurityContextProvider securityContextProvider  = new SecurityContextProvider();


    @RequestMapping(value = WELCOME_URL, method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseBean<Map<String, Object>> welcome() {
        final Map<String, Object> data = new HashMap<>();
        data.put("time", new Date());
        data.put("message", this.message + " " + securityContextProvider.getUserDetails());
        final ResponseBean<Map<String, Object>> responseBean = new ResponseBean<Map<String, Object>>();
        responseBean.setData(data);
        responseBean.setMessage("Request Process Successful");
        return responseBean;
    }


}
