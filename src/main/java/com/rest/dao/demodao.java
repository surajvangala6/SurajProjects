package com.rest.dao;

import java.util.List;

 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
 
import org.springframework.stereotype.Repository;
 

import com.rest.entity.*;

@Repository
public interface demodao  extends CrudRepository<entity, Integer>{
	 
	 
	
	@Query(value="SELECT *FROM students WHERE lastname=?1",nativeQuery=true)
	List<entity> getPersonInfoByLastName(String lastname);
	
	
}
