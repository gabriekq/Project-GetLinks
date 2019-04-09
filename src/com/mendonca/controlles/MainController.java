package com.mendonca.controlles;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.transaction.Transactional;
















import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mendonca.dao.LinkRecordDao;
import com.mendonca.dao.SubLinksManager;
import com.mendonca.dao.UserLinksDao;
import com.mendonca.model.LinkElement;
import com.mendonca.model.UserLinks;



@Controller
@Transactional
public class MainController {

    @Autowired
	private LinkRecordDao linkRecordDao;
    
    @Autowired
    private UserLinksDao userLinksDao;
    
    @Autowired
    private SubLinksManager subLinksManager;
    
	
	@RequestMapping(method = RequestMethod.GET, value = "linksender" )
	public ModelAndView DisplayPage(){
	ModelAndView modelAndView = new ModelAndView("sendLink");
	
	System.out.println("DisplayPage");
	
	return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "home" )
	public ModelAndView HomeTest(){
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST,value="linksave")
	public ModelAndView SaveFirstLink(String linkAdd){
		
		/*
		LinkElement  linkElement = new LinkElement();
		linkElement.setAccessed(0);
		linkElement.setWebAddress(linkAdd);
		linkRecordDao.saveLinkAddress(linkElement);
	   */
		
		
	   long idUser =  userLinksDao.getNumberRows();
	   idUser = idUser +1;
	   UserLinks userLinks = new UserLinks();
	   userLinks.setIdUser(idUser);
	   System.out.println(idUser);
	   
	   LinkElement linkElement = new LinkElement();
	   linkElement.setAccessed(0);
	   linkElement.setIdUser(idUser);
	   linkElement.setWebAddress(linkAdd);
	   
	   userLinksDao.saveUserLinks(userLinks);
	   linkRecordDao.saveLinkAddress(linkElement);
	   
	   
	
	  String page = "redirect:list/?".replace("?", String.valueOf(idUser));
		return  new ModelAndView(page);
     }


	
	
	
	
	//LIST ALL // NAO UTILIZAR SUBLINKS MANAGER POR INJEÇÃO UTILIZAR DE FORMA INDEPENDENTE
	@RequestMapping(method=RequestMethod.GET,value="list/{idUser}")
	public Callable<ModelAndView>  ListRows(@PathVariable String idUser){
	
		 
    return new Callable<ModelAndView>() {
	public ModelAndView call() throws Exception{
		
	LinkElement linkElement = linkRecordDao.getOneElement(Long.valueOf(idUser));
		
	linkElement.setAccessed(1);
	
	ArrayList<LinkElement> linksFound = subLinksManager.getSubLinks(linkElement.getWebAddress());	
	
	
	linksFound.stream().forEach(e -> e.setIdUser(Long.valueOf(idUser)));	
	linksFound.stream().forEach(e -> e.setAccessed(0));	
		
		
	linkRecordDao.saveListLinks(linksFound);
	linkRecordDao.updateRow(linkElement);	
		
	//ArrayList<LinkElement> linksByUser = linkRecordDao.getAllElements(Long.valueOf(idUser));	
	CopyOnWriteArrayList<LinkElement> linksByUser  = linkRecordDao.getAllElements(Long.valueOf(idUser));
	
	
	ModelAndView modelAndView = new ModelAndView("listLinks");
	modelAndView.addObject("ElementsList",linksByUser);	
	subLinksManager.closeDriver();
	return modelAndView;
		
	}
    
    }; 
     
     
		
	}
	
	
	
	
	
	
	
	
	
	//Sets and Gets Autowire
	
	
	public LinkRecordDao getLinkRecordDao() {
		return linkRecordDao;
	}


	
	public UserLinksDao getUserLinksDao() {
		return userLinksDao;
	}

	public void setUserLinksDao(UserLinksDao userLinksDao) {
		this.userLinksDao = userLinksDao;
	}

	public void setLinkRecordDao(LinkRecordDao linkRecordDao) {
		this.linkRecordDao = linkRecordDao;
	}

	public SubLinksManager getSubLinksManager() {
		return subLinksManager;
	}

	public void setSubLinksManager(SubLinksManager subLinksManager) {
		this.subLinksManager = subLinksManager;
	}


	

	
	
	
}
