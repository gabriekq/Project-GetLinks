package com.mendonca.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mendonca.dao.SubLinksManager;
import com.mendonca.model.LinkElement;






@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SubLinksManager.class})
public class WebDriverTest {

@Autowired	
private SubLinksManager subLinksManager;
	
	

public void setSubLinksManager(SubLinksManager subLinksManager) {
	this.subLinksManager = subLinksManager;
}


public SubLinksManager getSubLinksManager() {
	return subLinksManager;
}



@Test	
public void testWebDriver(){
	
	System.out.println("is  null -> "+subLinksManager);
	String urlTitle = subLinksManager.getTitle("https://www.uol.com.br/");
	System.out.println(urlTitle);
	Assert.assertNotNull(urlTitle);
	subLinksManager.closeDriver();
}	



	
@Test
public void testGetLinks(){
	ArrayList<LinkElement> links ;
	
   
	
   try {
	links = subLinksManager.getSubLinks("https://www.uol.com.br/");   
	   
   System.out.println("list size -> "+links.size() );
   links.stream().forEach(elem -> System.out.println(elem.getWebAddress()));
  
   } catch (NullPointerException e) {
	   e.printStackTrace();
   }
   
	subLinksManager.closeDriver();
	
	
}	
	
	
	
	
	
	
}
