package com.mendonca.test;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mendonca.conf.JPAConfiguration;
import com.mendonca.dao.LinkRecordDao;
import com.mendonca.dao.SubLinksManager;
import com.mendonca.model.LinkElement;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {LinkRecordDao.class,JPAConfiguration.class,SubLinksManager.class})
public class TestDao {


private LinkRecordDao linkRecordDao;
	
private  SubLinksManager subLinksManager;
	


public LinkRecordDao getLinkRecordDao() {
	return linkRecordDao;
}


@Autowired
public void setLinkRecordDao(LinkRecordDao linkRecordDao) {
	this.linkRecordDao = linkRecordDao;
}




public SubLinksManager getSubLinksManager() {
	return subLinksManager;
}


@Autowired
public void setSubLinksManager(SubLinksManager subLinksManager) {
	this.subLinksManager = subLinksManager;
}




@Test
public void testSaveList(){
	
	// test hire
	   ArrayList<LinkElement> links;
	   links  =  subLinksManager.getSubLinks("https://www.uol.com.br/");
	   System.out.println(links.size());
	   System.out.println("Object -> "+linkRecordDao);
	   linkRecordDao.saveListLinks(links);
	
	subLinksManager.closeDriver();
	//linkRecordDao.CloseTransaction();
	//linkRecordDao.saveLinkAddress(LinkElement);
}




@Test
public void TestListLinks(){
	
ArrayList<LinkElement>links =	  linkRecordDao.getAllElements();

System.out.println(links.size());

links.stream().forEach(E -> System.out.println("print -> "+E.getWebAddress()) );
linkRecordDao.closeTransaction();	
	
}


@Test
public void testGetOne(){
	
LinkElement linkElement =	 linkRecordDao.getOneElement();

System.out.println(linkElement.getAccessed());
System.out.println(linkElement.getWebAddress());
	
}



	
	
	
	
	
}
