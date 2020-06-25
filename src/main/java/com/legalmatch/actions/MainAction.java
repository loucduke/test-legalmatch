/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author loucarmendoza
 */
@Actions(value = {
    @Action(value = "main", 
        results = {
            @Result(name="success", location="main.vm")
        }
    )
})
public class MainAction { }
