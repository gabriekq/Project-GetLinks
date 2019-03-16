package com.mendonca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;



@Entity
public class LinkElement {

	
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int Id;
	
@Column(columnDefinition ="MEDIUMTEXT" )
private String webAddress;
private int accessed;



public String getWebAddress() {
	return webAddress;
}

public void setWebAddress(String webAddress) {
	this.webAddress = webAddress;
}

public int getAccessed() {
	return accessed;
}

public void setAccessed(int accessed) {
	this.accessed = accessed;
}






	
	
}
