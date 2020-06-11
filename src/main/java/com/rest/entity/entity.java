package com.rest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Id;

@Entity
@Table(name = "students")
@DynamicUpdate
public class entity implements Serializable{

	 public entity() {
		 
	 }
	 
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name = "id")
	    Integer Id;
	 
	    @Column(name = "firstname")
	    String firstname;
	 
	    @Column(name = "lastname")
	    String lastname;
	    public entity(int id,String firstname, String lastname) {
			super();
			this.Id=id;
			this.firstname = firstname;
			this.lastname = lastname;
			 
		}
	    public Integer getId() {
	        return Id;
	    }
	 
	    public void setId(Integer id) {
	        Id = id;
	    }
	 
	    public String getfirstName() {
	        return firstname;
	    }
	 
	    public void setfirstName(String firstname) {
	        this.firstname = firstname;
	    }
	 
	    public String getLastName() {
	        return lastname;
	    }
	 
	    public void setlastName(String lastname) {
	        this.lastname = lastname;
	    }
	    
	    @Override
		public String toString() {
			return "entity [id=" + 	Id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
		}
	 
	}


