package com.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class UserDao {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    
	    private long id;
	   @Column(name = "username")
	    private String username;
	   @Column(name = "password")
	    @JsonIgnore
	    private String password;

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
}
