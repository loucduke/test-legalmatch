/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author loucarmendoza
 */
@Entity
@Table(name = "employees")
public class Employee implements Serializable{
    
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "middle_name")
    private String middleName;
    
    @Column(name = "birth_date")
    private Date birthDate;
    
    @Column(name = "marital_status")
    private String maritalStatus;
    
    @Column(name = "position")
    private String position;
    
    @Column(name = "date_hired")
    private Date dateHired;
    
    @Column(name = "gender")
    private String gender;
    
    @JsonIgnoreProperties("employee")
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER ,cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AddressInfo> addresses;
    
    @JsonIgnoreProperties("employee")
    @OneToMany(mappedBy = "employee",  fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContactInfo> contacts;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public Set<AddressInfo> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressInfo> addresses) {
        this.addresses = addresses;
    }

    public Set<ContactInfo> getContacts() {
        return contacts;
    }

    public void setContacts(Set<ContactInfo> contacts) {
        this.contacts = contacts;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
}
