package com.espark.adarsh.persistence.repositories;

import com.espark.adarsh.persistence.entites.impl.Task;

import java.util.Collection;

public interface TaskRepository<T> {


    public Long size();

    public void refreshTask(Task task);

    public Boolean saveTask(Task task);

    public Task getTask(Task task);

    public Task getTaskById(Task task);

    public Task getTaskByName(Task task);

    public Boolean deleteTask(Task task);

    public Task updateTask(Task task);

    public Collection<Task> getAllTask();

}
