/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.rest.services;

import com.legalmatch.dao.IDAO;
import com.legalmatch.models.AddressInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author loucarmendoza
 */
@Component
public class AddressInfoController extends AbstractController<AddressInfo> {
    
    @Autowired
    @Qualifier(value = "addressInfo")
    private IDAO<AddressInfo> repository;

    @Override
    protected IDAO<AddressInfo> getRepository() {
        return repository;
    }
    
    
}
