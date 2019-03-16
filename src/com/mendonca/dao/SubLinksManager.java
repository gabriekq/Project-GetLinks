package com.mendonca.dao;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//import javax.lang.model.element.Element;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.springframework.stereotype.Component;
//import org.openqa.selenium.chrome.ChromeOptions;


import com.mendonca.model.LinkElement;

//@Component
public class SubLinksManager {

	
	// using selenum to get de sub links
	
    private	ChromeDriver driver;
  //  private	ChromeOptions options; // try to use
    
	public  SubLinksManager(){
		
	// options = new ChromeOptions();
	 //options.setHeadless(true);
	 //System.setProperty("webdriver.chrome.driver", "C:\\Programas mendonca\\chromeDriver\\chromedriver.exe");
	
	System.setProperty("webdriver.chrome.driver", "C:\\Programas mendonca\\chromeDriver\\chromedriver.exe");
	driver = new ChromeDriver();
	  
	
	Robot robot;
	try {
		robot = new Robot();
		 robot.keyPress(KeyEvent.VK_WINDOWS);
	     robot.keyPress(KeyEvent.VK_DOWN);
	     robot.keyPress(KeyEvent.VK_DOWN);
	     robot.keyRelease(KeyEvent.VK_WINDOWS);
	     robot.keyRelease(KeyEvent.VK_DOWN);
	     robot.keyRelease(KeyEvent.VK_DOWN);	
	} catch (AWTException e) {
		e.printStackTrace();
	}
		
	
	
	}
	
	
	public String getTitle(String url){
		
		driver.get(url);
		return driver.getTitle();
	}
	
	
	public void closeDriver(){
	Process command;	
	driver.close();
		
		try{
			
			command =  Runtime.getRuntime().exec("tskill chromedriver");
			if(command.waitFor()==0){
				System.out.println("closing...");
			}else{
				System.out.println("erro to close");
			}
			
		}catch(IOException exception ){
			exception.printStackTrace();
		}catch(InterruptedException exception){
			exception.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	public ArrayList<LinkElement> getSubLinks(String url){
		ArrayList<LinkElement> linksFound = new ArrayList<LinkElement>();
		
		driver.get(url);
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		for (WebElement link : allLinks){
			
			 
			if((link.getAttribute("href") != null) && link.getAttribute("href").toLowerCase().contains("http".toLowerCase())   ){	   
			 
				LinkElement linkElement = new LinkElement();
				linkElement.setAccessed(0);
				linkElement.setWebAddress(link.getAttribute("href"));
				linksFound.add(linkElement);   
			   }	
		}
		
		return linksFound;
	}
	
	
	
	
	
}
