package com.mendonca.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mendonca.model.LinkElement;

//@Component

@Transactional
@Repository
public class LinkRecordDao {

@PersistenceContext	
private EntityManager manager;
	


public void saveLinkAddress(LinkElement linkElement){
	manager.persist(linkElement);
}
	

public void closeTransaction(){
	manager.close();
}


public void saveListLinks(ArrayList<LinkElement> LinkElementList ){
	
	for(LinkElement linkElement : LinkElementList  ){
		manager.persist(linkElement);
	}
}
	


public ArrayList<LinkElement> getAllElements(){
	
    List<LinkElement> linksList =   manager.createQuery("SELECT E FROM LinkElement E ", LinkElement.class).getResultList();
	return (ArrayList<LinkElement>) linksList;
	
}


public LinkElement getOneElement(){
	
List<LinkElement> linksList =   manager.createQuery("SELECT E FROM LinkElement E WHERE E.accessed = 0 ", LinkElement.class).getResultList();
return linksList.get(0)   ;

}


public void updateRow(LinkElement  linkElement  ){
	manager.merge(linkElement);
}


	
	
}


