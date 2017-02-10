package com.espark.adarsh.persistence.entites.impl;

import com.espark.adarsh.persistence.entites.construct.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "UserRole")
public final class UserRole extends AbstractEntity<Long> {

    @Column(nullable = false, length = 100)
    private String name;

    public UserRole() {
        super(UserRole.class);
    }

    public UserRole(String name) {
        super(UserRole.class);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "name='" + name + '\'' +
                '}';
    }
}
