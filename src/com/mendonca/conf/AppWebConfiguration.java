package com.mendonca.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mendonca.aop.ControllerAspect;
import com.mendonca.controlles.MainController;
import com.mendonca.dao.LinkRecordDao;


@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan(basePackageClasses={MainController.class,LinkRecordDao.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver
	internalResourceViewResolver() {
	InternalResourceViewResolver resolver =	new InternalResourceViewResolver();
	resolver.setPrefix("/WEB-INF/views/");
	resolver.setSuffix(".jsp");
	return resolver;
	}
	
	
	
	@Bean
	public MultipartResolver multipartResolver(){
	return new StandardServletMultipartResolver();
	}

	
	@Bean 
	public ControllerAspect controllerAspect(){
	return new ControllerAspect();
	}
	
	
	
	
}
