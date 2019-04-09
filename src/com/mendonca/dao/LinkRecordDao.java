package com.mendonca.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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


public synchronized void saveListLinks(ArrayList<LinkElement> LinkElementList ){
	
	for(LinkElement linkElement : LinkElementList  ){
		manager.persist(linkElement);
	}
}
	


public synchronized CopyOnWriteArrayList<LinkElement> getAllElements(long idUser){
	
   // List<LinkElement> linksList =   manager.createQuery("SELECT E FROM LinkElement E ", LinkElement.class).getResultList();
	String sqlQuery = "SELECT E FROM LinkElement E WHERE E.accessed = 0 AND E.idUser = ? ".replace("?",String.valueOf(idUser));	
	List<LinkElement> linksList =  manager.createQuery(sqlQuery, LinkElement.class).getResultList();
	
	CopyOnWriteArrayList<LinkElement> linksListSync =  new CopyOnWriteArrayList<LinkElement>();
	
	for(LinkElement link : linksList) {	
	linksListSync.add(link);
		
	}
	
	
	return linksListSync;
	
}


public synchronized LinkElement getOneElement(long idUser){
	
// capitura o primeiro element de um determinado ID
	
String sqlQuery = "SELECT E FROM LinkElement E WHERE E.accessed = 0 AND E.idUser = ? ".replace("?",String.valueOf(idUser));	
List<LinkElement> linksList = manager.createQuery(sqlQuery, LinkElement.class).getResultList();
	
return linksList.get(0);

}


public void updateRow(LinkElement  linkElement  ){
	manager.merge(linkElement);
}


	
	
}


