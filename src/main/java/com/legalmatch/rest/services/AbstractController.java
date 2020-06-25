/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.rest.services;

import com.legalmatch.dao.IDAO;
import com.legalmatch.models.Employee;
import com.opensymphony.xwork2.ModelDriven;
import java.lang.reflect.Field;
import java.util.List;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author loucarmendoza
 */
@Component
public abstract class AbstractController<T> implements ModelDriven<Object>{
    
    private List<T> list;
            
    private String id;
    
    private T model;

    @Autowired
    private IDAO<T> modelRepository;
    
    
    @Override
    public Object getModel() {
        return (list != null ? list : model);
    }

    
    public void setId(String id) {
        if (id != null) {
            this.model = modelRepository.findOne(Long.valueOf(id));
        }
        this.id = id;
    }
    
    public HttpHeaders show() {
        return new DefaultHttpHeaders("show");
    }

    public HttpHeaders index() {
        list = modelRepository.findAll();
        return new DefaultHttpHeaders("index");
    }
    
    public String edit() {
        return "edit";
    }


    public String destroy() {
        modelRepository.deleteById(Long.valueOf(id));
        return "success";
    }

    public HttpHeaders create() throws NoSuchFieldException, IllegalAccessException {
        
        modelRepository.save(model);
        return new DefaultHttpHeaders("success")
            .setLocationId(getModelId(model));
    }

    public String update() {
        modelRepository.update(model);
        return "success";
    }    
    
    
    private Long getModelId(T model) throws NoSuchFieldException, IllegalAccessException {
        Class clazz = model.getClass();
        Field field = clazz.getField("id");
        
        return (Long) field.get(model);
    }
}
