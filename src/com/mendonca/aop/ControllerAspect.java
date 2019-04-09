package com.mendonca.aop;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.mendonca.dao.LinkRecordDao;
import com.mendonca.dao.SubLinksManager;
import com.mendonca.model.LinkElement;


@Aspect
@Component
public class ControllerAspect {

	/*
	
@Autowired	
private LinkRecordDao linkRecordDao;	
	


@Before("execution(* com.mendonca.controlles.MainController.DisplayPage())")
public void runBefore(){
	
System.out.println(" Before the method DisplayPage() ");
	
}	


	
@Before("execution(* com.mendonca.controlles.MainController.ListRows())")
public void runBeforeList(){
	
System.out.println("APO running .. before the method ListRows()");
LinkElement  linkElement   = linkRecordDao.getOneElement();

SubLinksManager subLinksManager = new SubLinksManager();
ArrayList<LinkElement>linksFound = subLinksManager.getSubLinks(linkElement.getWebAddress());
subLinksManager.closeDriver();

linkRecordDao.saveListLinks(linksFound);
linkElement.setAccessed(1);
linkRecordDao.updateRow(linkElement);

}


@After("execution(* com.mendonca.controlles.MainController.SaveFirstLink(..))")
public void runAfterSave(){
	
	System.out.println("After the method Save");
	
	
}





public LinkRecordDao getLinkRecordDao() {
	return linkRecordDao;
}

public void setLinkRecordDao(LinkRecordDao linkRecordDao) {
	this.linkRecordDao = linkRecordDao;
}

*/


	
}
