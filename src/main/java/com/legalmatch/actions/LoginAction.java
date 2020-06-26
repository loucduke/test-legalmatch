/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Result;
/**
 *
 * @author loucarmendoza
 */
@Result(name="success", location="login.vm", type="velocity")
public class LoginAction extends ActionSupport{
}
