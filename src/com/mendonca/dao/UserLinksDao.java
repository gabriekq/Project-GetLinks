package com.mendonca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.stereotype.Repository;

import com.mendonca.model.UserLinks;

@Transactional
@Repository
public class UserLinksDao {

	
@PersistenceContext	
private EntityManager manager;	
	


public void saveUserLinks(UserLinks  userLinks ){
manager.persist(userLinks);
}
	
	
public void closeTransaction(){
	manager.close();
}

	
public long getNumberRows(){
long rows;	
	
	
String sqlQuery = "SELECT U FROM UserLinks U";
	
List<UserLinks> users  = manager.createQuery(sqlQuery,UserLinks.class).getResultList();	
rows = users.size();

return rows;
	
}

	
	
	
	
}
