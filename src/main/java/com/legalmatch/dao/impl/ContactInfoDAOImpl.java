/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.dao.impl;

import com.legalmatch.dao.IDAO;
import com.legalmatch.models.ContactInfo;
import org.springframework.stereotype.Repository;

/**
 *
 * @author loucarmendoza
 */
@Repository("contactInfo")
public class ContactInfoDAOImpl extends AbstractDAO<ContactInfo> implements IDAO<ContactInfo>{
    public ContactInfoDAOImpl(){
        setClazz(ContactInfo.class);
    }
}
