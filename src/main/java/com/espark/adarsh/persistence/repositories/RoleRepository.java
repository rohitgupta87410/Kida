package com.espark.adarsh.persistence.repositories;

import com.espark.adarsh.persistence.entites.impl.User;
import com.espark.adarsh.persistence.entites.impl.UserRole;

import java.util.List;

public interface RoleRepository <T> {

    public Long size();
    public void refreshUser(UserRole userRole);
    public UserRole getRoleByName(String roleName);
    public Boolean saveUserRole(UserRole userRole);
    public Boolean updateUserRole(UserRole userRole);
    public Boolean dropUserRole(UserRole userRole);
    public UserRole getUserRole(User user);
    public List<T> getAllUserRole(User user);
}
