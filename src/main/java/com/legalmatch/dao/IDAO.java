/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.dao;

import java.util.List;

/**
 *
 * @author loucarmendoza
 */
public interface IDAO<T> {
    T findOne(long id);

    List<T> findAll();

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(long entityId);

}
