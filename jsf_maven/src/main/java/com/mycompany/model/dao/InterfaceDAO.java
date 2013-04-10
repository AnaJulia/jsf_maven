
package com.mycompany.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

public interface InterfaceDAO<T>{
    
    
    void save(T entity);
    void update (T entity);
    void remove(T entity);
    void merge(T entity);
    
    
    
   //recuperar objeto 
    T getEntity(Serializable id);
    T getEntityByDetacheCriteria(DetachedCriteria criteria);
    //list=referente aqualquer entidade e getlist==pega todas as entidades
    List<T>getEntities();
   List<T>getlistByDetachedCriteria(DetachedCriteria criteria);
    
    
    
    
}
