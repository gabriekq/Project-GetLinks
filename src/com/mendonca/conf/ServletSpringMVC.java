package com.mendonca.conf;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Enviar para o method abaixo
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[]{AppWebConfiguration.class,JPAConfiguration.class  }  ;
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

	
	
	
	@Override  // I will not use this but in case
	protected void customizeRegistration(Dynamic registration) {
	registration.setMultipartConfig(
	new MultipartConfigElement(""));
}
	
	
	
	
	
	
}
