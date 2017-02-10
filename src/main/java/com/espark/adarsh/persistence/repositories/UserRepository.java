package com.espark.adarsh.persistence.repositories;

import com.espark.adarsh.persistence.entites.impl.User;

import java.util.Collection;

public interface UserRepository<T> {


    public Long size();

    public void refreshUser(User user);

    public Boolean saveUser(User user);

    public User getUser(User user);

    public User getUserById(User user);

    public User getUserByName(User user);

    public Boolean deleteUser(User user);

    public User updateUser(User user);

    public Collection<User> getAllUser();

}
