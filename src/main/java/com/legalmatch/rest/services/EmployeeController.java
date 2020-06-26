/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.rest.services;

import com.legalmatch.dao.EmployeeDao;
import com.legalmatch.models.Employee;
import com.legalmatch.models.search.EmployeeSearch;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author loucarmendoza
 */
@Controller
public class EmployeeController implements ModelDriven<Object>{

    @Autowired
    private EmployeeDao repository;

    private Long id;
    
    private Integer page;
    
    private Integer perPage;

    private String text;

    private EmployeeSearch empSearch;
    
    private Employee emp;

   
    @Override
    public Object getModel() {
        return (emp != null ? emp : empSearch);
    }
    
   
    public void setId(Long id) {
        this.id = id;
    }
    
    public HttpHeaders show() {
        return new DefaultHttpHeaders("show");
    }

    public HttpHeaders index() {
        empSearch = new EmployeeSearch();
        empSearch.setEmployees(repository.find(perPage, page, text));
        empSearch.setTotalCount(repository.getEmployeeCount());
        return new DefaultHttpHeaders("index");
    }
    
    public String edit() {
        return "edit";
    }


    public String destroy() {
        repository.deleteById(Long.valueOf(id));
        return "success";
    }

    public HttpHeaders create() throws NoSuchFieldException, IllegalAccessException {
        repository.save(emp);
        return new DefaultHttpHeaders("create")
            .setLocationId(emp.getId());
    }

    public String update() {
        repository.update(emp);
        return "update";
    }    

    public EmployeeSearch getEmpSearch() {
        return empSearch;
    }

    // state setter getters

    public void setEmpSearch(EmployeeSearch empSearch) {
        this.empSearch = empSearch;
    }
    
    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee employee) {
        this.emp = employee;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    

}
