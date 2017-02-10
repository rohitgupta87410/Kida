package com.espark.adarsh.persistence.repositories.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.espark.adarsh.persistence.entites.impl.Task;
import com.espark.adarsh.persistence.repositories.TaskRepository;
import com.espark.adarsh.persistence.repositories.construct.AbstractRepository;

@Repository
public class TaskRepositoryImpl extends AbstractRepository<Task>
        implements TaskRepository<Task> {

    public TaskRepositoryImpl() {
        super(Task.class);
    }

    @Override
    @Transactional
    public Boolean saveTask(Task task) {
        super.put(task);
        return null;
    }

    @Override
    @Transactional
    public Task getTask(Task task) {
        return getUniqueByExample(task);
    }

    @Override
    @Transactional
    public Task getTaskById(Task task) {
        return (Task) super.getEntityById(task);
    }

    @Override
    @Transactional
    public Task getTaskByName(Task task) {
        return (Task) super.getByColumnName("taskname",task.gettaskname());
    }

    @Override
    @Transactional
    public Boolean deleteTask(Task task) {
        super.remove(task);
        return null;
    }

    @Override
    @Transactional
    public Task updateTask(Task task) {
        super.update(task);
        return null;
    }


    @Override
    @Transactional
    public Collection<Task> getAllTask() {
        return getAll();
    }


    /*@Transactional
    public Task getFacebookTask(String facebookTaskEmailId){
        Criteria criteria=getSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("taskEmail",facebookTaskEmailId)) ;
        Object object=criteria.uniqueResult();
        if(object!=null){
            return (Task)object;
        }
        return (Task)object;
    }*/

    @Override
    @Transactional
    public Long size() {
        return super.size();
    }

    @Override
    public void refreshTask(Task task) {
        super.refresh(task);
    }
}