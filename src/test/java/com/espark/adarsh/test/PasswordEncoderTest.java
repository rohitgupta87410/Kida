package com.espark.adarsh.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        System.out.println("Encryption of sukhdev pwd "+new BCryptPasswordEncoder().encode("sukhdev"));
        System.out.println("Encryption of Admin pwd "+new BCryptPasswordEncoder().encode("admin"));
        System.out.println("Encryption of User pwd "+new BCryptPasswordEncoder().encode("user"));
    }
}
