/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.dao.impl;

import com.legalmatch.dao.UserDAO;
import com.legalmatch.models.auth.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author loucarmendoza
 */
@Repository
public class UserDAOImpl extends AbstractDAO<User> implements UserDAO{
    
   public UserDAOImpl() {
       setClazz(User.class);
   }
    
}
