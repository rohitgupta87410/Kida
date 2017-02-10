package com.espark.adarsh.web.manager;

import com.espark.adarsh.persistence.entites.impl.Task;
import com.espark.adarsh.persistence.entites.impl.User;
import com.espark.adarsh.persistence.entites.impl.UserRole;

import java.util.Collection;

public interface UserManager <M> {
    public void refreshUser(User user);
    public Boolean saveUser(User user);
    public Boolean updateUser(User user);
    public Boolean deleteUser(User user);
    public User getUser(User user);
    public User getUserById(User user);
    public User getUserByName(User user);
    public Collection<User> getAllUser();
    public UserRole getUserRole(String roleName);
    
    public void refreshTask(Task task);
    public Boolean saveTask(Task task);
    public Boolean updateTask(Task task);
    public Boolean deleteTask(Task task);
    public Task getTask(Task task);
    public Task getTaskById(Task task);
    public Task getTaskByName(Task task);
    public Collection<Task> getAllTask();
}
