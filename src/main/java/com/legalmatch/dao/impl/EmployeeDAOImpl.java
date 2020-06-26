/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.dao.impl;

import com.legalmatch.dao.EmployeeDao;
import com.legalmatch.models.AddressInfo;
import com.legalmatch.models.ContactInfo;
import com.legalmatch.models.Employee;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author loucarmendoza
 */
@Repository("employee")
public class EmployeeDAOImpl extends AbstractDAO<Employee> implements EmployeeDao{
    
    public EmployeeDAOImpl() {
        setClazz(Employee.class);
    }

    @Override
    public List<Employee> find(Integer pageSize, Integer offset, String text) {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();

        CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
        Root<Employee> root = cr.from(Employee.class);
        cr.select(root);


        if(text != null && !text.isEmpty()){
            cr.where(
                cb.like(cb.lower(root.<String>get("firstName")), "%"+text.toLowerCase()+"%")
            );            
        }
        
        Query<Employee> q = getCurrentSession().createQuery(cr);
        
        q.setMaxResults(pageSize);
        q.setFirstResult((offset - 1) * pageSize);
        
        return q.getResultList();
    }

    @Override
    public Integer getEmployeeCount() {
        CriteriaBuilder criteriaCount = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Long> cr = criteriaCount.createQuery(Long.class);
        Root<Employee> root = cr.from(Employee.class);
        cr.select(criteriaCount.count(root));

        Query<Long> q = getCurrentSession().createQuery(cr);

        return q.uniqueResult().intValue();
    }

    @Override
    public Employee save(Employee emp) {

        if(emp != null){
            for(ContactInfo c : emp.getContacts()){
                System.out.println("saving parent emp");
                c.setEmployee(emp);
            }
            for(AddressInfo a : emp.getAddresses()){
                a.setEmployee(emp);
            }
            
        }    
            
        return super.save(emp); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
