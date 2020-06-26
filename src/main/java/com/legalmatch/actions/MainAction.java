/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author loucarmendoza
 */

@Result(name="success", location="main.vm", type="velocity")
public class MainAction extends ActionSupport{

    private List<String> roles;
    
    public List<String> getRoles() {
        return roles;
    }
    
    public String execute() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        roles = new ArrayList<String>();
        
        for (GrantedAuthority authority : auth.getAuthorities()) {
            roles.add(authority.getAuthority());
        }
        
        return "success"; 
    }
    
}
