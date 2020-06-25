/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.dao.impl;

import com.legalmatch.dao.AddressInfoDAO;
import com.legalmatch.dao.IDAO;
import com.legalmatch.models.AddressInfo;
import org.springframework.stereotype.Repository;

/**
 *
 * @author loucarmendoza
 */
@Repository
public class AddressInfoDAOImpl extends AbstractDAO<AddressInfo> implements AddressInfoDAO{
    public AddressInfoDAOImpl() {
        setClazz(AddressInfo.class);
    }
}
