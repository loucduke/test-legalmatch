/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.dao.impl;

import com.legalmatch.dao.RoleDAO;
import com.legalmatch.models.auth.Role;
import org.springframework.stereotype.Repository;

/**
 *
 * @author loucarmendoza
 */
@Repository
public class RoleDAOImpl extends AbstractDAO<Role> implements RoleDAO{
    
   public RoleDAOImpl() {
       setClazz(Role.class);
   }
    
}

