/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.rest.services;

import com.legalmatch.dao.IDAO;
import com.legalmatch.models.Employee;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author loucarmendoza
 */
public class EmployeeController extends AbstractController<Employee>{

//    private List<Employee> list;
//            
//    private String id;
//    
//    private Employee model;
//
//    @Autowired
//    private IDAO<Employee> employeeRepository;
//
//    @Override
//    public Object getModel() {
//        return (list != null ? list : model);
//    }
//
//    
//    public void setId(String id) {
//        if (id != null) {
//            this.model = employeeRepository.findOne(Long.valueOf(id));
//        }
//        this.id = id;
//    }
//    
//    public HttpHeaders show() {
//        return new DefaultHttpHeaders("show");
//    }
//
//    public HttpHeaders index() {
//        list = employeeRepository.findAll();
//        return new DefaultHttpHeaders("index");
//    }
//    
//    public String edit() {
//        return "edit";
//    }
//
//
//    public String destroy() {
//        employeeRepository.deleteById(Long.valueOf(id));
//        return "success";
//    }
//
//    public HttpHeaders create() {
//        employeeRepository.save(model);
//        return new DefaultHttpHeaders("success")
//            .setLocationId(model.getId());
//    }
//
//    public String update() {
//        employeeRepository.update(model);
//        return "success";
//    }
    
}
