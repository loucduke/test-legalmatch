/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.dao.impl;

import com.legalmatch.dao.EmployeeDAO;
import com.legalmatch.dao.IDAO;
import com.legalmatch.models.Employee;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author loucarmendoza
 */
@Repository
public class EmployeeDAOImpl extends AbstractDAO<Employee> implements IDAO<Employee>{
    
    public EmployeeDAOImpl() {
        setClazz(Employee.class);
    }
    
}
