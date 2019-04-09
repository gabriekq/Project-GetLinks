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

private long idUser; // this variable will be change soon to many to one - one user has many links


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

public long getIdUser() {
	return idUser;
}

public void setIdUser(long idUser) {
	this.idUser = idUser;
}










	
	
}
