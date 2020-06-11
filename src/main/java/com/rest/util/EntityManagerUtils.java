/*package com.rest.util;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class EntityManagerUtils {
	@Autowired
    @Qualifier("mainEntityManager")
    private EntityManager mainDatabase;

    @Autowired
    @Qualifier("secondEntityManager")
    private EntityManager secondDatabase;

     

    public EntityManager getEm(String url){

        if(url.contains("main"))
            return mainDatabase;
        if(url.contains("second"))
            return secondDatabase;
        return mainDatabase;
    }

    public JpaRepositoryFactory getJpaFactory(String url){
        return new JpaRepositoryFactory( getEm(url) );
    }

}*/
