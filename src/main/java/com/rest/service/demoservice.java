package com.rest.service;
import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Service;

import com.rest.dao.*; 
import com.rest.entity.*;

@Service
public class demoservice {
	@Autowired
	private  demodao Demodao;
	
	public List<entity> getPersonInfoByLastName(String lastName) {
		return Demodao.getPersonInfoByLastName(lastName);
	}
}