package com.espark.adarsh.persistence.entites.construct;

import java.io.Serializable;

public interface Entity<E extends Serializable> extends Serializable,Cloneable,Comparable{

    public E getId();

    public void setId(E id);

}