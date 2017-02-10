package com.espark.adarsh.web.manager;

import com.espark.adarsh.persistence.entites.impl.Task;
import com.espark.adarsh.persistence.entites.impl.User;
import com.espark.adarsh.persistence.entites.impl.UserRole;
import com.espark.adarsh.persistence.repositories.RoleRepository;
import com.espark.adarsh.persistence.repositories.TaskRepository;
import com.espark.adarsh.persistence.repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
final public class UserManagerImpl
        implements UserManager {

    private final static Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);

    public UserManagerImpl() {
    }

    @Override
    public void refreshUser(User user) {
        userRepository.refreshUser(user);
    }

    @Transactional
    public Boolean saveUser(User user) {
        userRepository.saveUser(user);
        return null;
    }

    @Transactional
    public Boolean updateUser(User user) {
        userRepository.updateUser(user);
        return null;
    }

    @Transactional
    public Boolean deleteUser(User user) {
        userRepository.deleteUser(user);
        return null;
    }

    public User getUser(final User user) {
        return  userRepository.getUser(user);
    }

    @Override
    public Collection<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public User getUserById(User user) {
        return userRepository.getUserById(user);
    }

    @Override
    public User getUserByName(User user) {
        return userRepository.getUserByName(user);
    }

    @Override
    public UserRole getUserRole(String roleName) {
        return roleRepository.getRoleByName(roleName);
    }

    @Qualifier("userRepositoryImpl")
    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Qualifier("roleRepositoryImpl")
    @Autowired
    private RoleRepository roleRepository;

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    
    @Override
    public void refreshTask(Task task) {
        taskRepository.refreshTask(task);
    }

    @Transactional
    public Boolean saveTask(Task task) {
        taskRepository.saveTask(task);
        return null;
    }

    @Transactional
    public Boolean updateTask(Task task) {
    	taskRepository.updateTask(task);
        return null;
    }

    @Transactional
    public Boolean deleteTask(Task task) {
    	taskRepository.deleteTask(task);
        return null;
    }

    public Task getTask(final Task task) {
        return  taskRepository.getTask(task);
    }

    @Override
    public Collection<Task> getAllTask() {
        return taskRepository.getAllTask();
    }

    @Override
    public Task getTaskById(Task task) {
        return taskRepository.getTaskById(task);
    }

    @Override
    public Task getTaskByName(Task task) {
        return taskRepository.getTaskByName(task);
    }

    @Qualifier("taskRepositoryImpl")
    @Autowired
    private TaskRepository taskRepository;

    public void setTaskRepository(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
