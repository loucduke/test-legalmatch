/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.dao;

import com.legalmatch.models.Employee;
import java.util.List;

/**
 *
 * @author loucarmendoza
 */
public interface EmployeeDao extends IDAO<Employee>{
    
    public List<Employee> find(Integer max, Integer offset, String text);

    public Integer getEmployeeCount();
}
