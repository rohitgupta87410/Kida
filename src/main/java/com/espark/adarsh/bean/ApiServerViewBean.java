package com.espark.adarsh.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

@JsonPropertyOrder({"userName", "userPassword","token","message","httpStatus"})
public class ApiServerViewBean implements Serializable {


    @JsonProperty("User-Name")
    private String userName;


    @JsonProperty("User-Password")
    private String userPassword;


    @JsonProperty("Authentication-token")
    private String token;


    @JsonProperty("Response-Message")
    private String message;


    @JsonProperty("Response-Status")
    private Integer httpStatus;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }
}
