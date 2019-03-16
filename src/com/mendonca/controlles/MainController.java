package com.mendonca.controlles;


import java.util.ArrayList;

import javax.transaction.Transactional;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mendonca.dao.LinkRecordDao;
import com.mendonca.dao.SubLinksManager;
import com.mendonca.model.LinkElement;



@Controller
@Transactional
public class MainController {

    @Autowired
	private LinkRecordDao linkRecordDao;
	
	@RequestMapping(method = RequestMethod.GET, value = "linksender" )
	public ModelAndView DisplayPage(){
	ModelAndView modelAndView = new ModelAndView("sendLink");
	
	System.out.println("DisplayPage");
	
	return modelAndView;
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST,value="linksave")
	public ModelAndView save(String linkAdd){
		
		LinkElement  linkElement = new LinkElement();
		linkElement.setAccessed(0);
		linkElement.setWebAddress(linkAdd);
		linkRecordDao.saveLinkAddress(linkElement);
	
		return  new ModelAndView("redirect:list");
     }


	
	@RequestMapping(method=RequestMethod.GET,value="list")
	public ModelAndView ListRows(){
	ModelAndView modelAndView = new ModelAndView("listLinks");	
	
	ArrayList<LinkElement> ElementsList =  linkRecordDao.getAllElements();
	// only reads ever row
	modelAndView.addObject("ElementsList", ElementsList);
	return modelAndView;	
	}
	
	
	
	public LinkRecordDao getLinkRecordDao() {
		return linkRecordDao;
	}


	
	public void setLinkRecordDao(LinkRecordDao linkRecordDao) {
		this.linkRecordDao = linkRecordDao;
	}


	
}
