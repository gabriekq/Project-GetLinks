package com.mendonca.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mendonca.conf.JPAConfiguration;
import com.mendonca.dao.SubLinksManager;
import com.mendonca.dao.UserLinksDao;
import com.mendonca.model.UserLinks;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={UserLinksDao.class,JPAConfiguration.class})
public class TestDaoUser {

private UserLinksDao userLinksDao;

public UserLinksDao getUserLinksDao() {
	return userLinksDao;
}

@Autowired
public void setUserLinksDao(UserLinksDao userLinksDao) {
	this.userLinksDao = userLinksDao;
}


//@Test
public void testUserAdd(){
	
UserLinks userLinks = new UserLinks();
userLinks.setIdUser(1);
	
userLinksDao.saveUserLinks(userLinks);	
	
	
}


@Test
public void readRows(){

long rows   = userLinksDao.getNumberRows();

System.out.println(rows);
	
	
}

	
	
	
	
	
	
	
	
	
	
}
