/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.rest.services;

import com.legalmatch.dao.IDAO;
import com.legalmatch.models.ContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author loucarmendoza
 */
@Component
public class ContactInfoController extends AbstractController<ContactInfo>{
    
    @Autowired
    @Qualifier(value = "contactInfo")
    private IDAO<ContactInfo> repository;

    @Override
    protected IDAO<ContactInfo> getRepository() {
        return repository;
    }

}
