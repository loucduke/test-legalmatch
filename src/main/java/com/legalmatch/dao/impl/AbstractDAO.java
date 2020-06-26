/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author loucarmendoza
 */
@Transactional
public class AbstractDAO <T> {
    private Class< T > clazz;
 
   @Autowired
   private SessionFactory sessionFactory;
 
   public void setClazz(Class< T > clazzToSet) {
      clazz = clazzToSet;
   }
 
   public T findOne(long id) {
      return (T) getCurrentSession().get( clazz, id );
   }
   public List< T > findAll() {
      return getCurrentSession()
       .createQuery( "from " + clazz.getName() ).list();
   }
 
   public T save(T entity) {
      getCurrentSession().save( entity );
      getCurrentSession().flush();
      return entity;
   }
 
   public T update(T entity) {
      getCurrentSession().merge( entity );
      return entity;
   }
   
 
   public void delete(T entity) {
      getCurrentSession().delete( entity );
   }
   public void deleteById(long id) {
      final T entity = findOne( id);
      delete( entity );
   }
 
   protected final Session getCurrentSession(){
      return sessionFactory.getCurrentSession();
   }

}
