package com.TotalWork.CompleteTraining;


import com.TotalWork.CompleteTraining.model.Role;
import com.TotalWork.CompleteTraining.model.User;
import com.TotalWork.CompleteTraining.repositry.RoleRepositry;
import com.TotalWork.CompleteTraining.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication

public class CompleteTrainingApplication  {


	@Autowired
	private RoleRepositry roleRepositry;

	@Autowired
	private UserRepositry userRepositry;

	public static void main(String[] args) {
		SpringApplication.run(CompleteTrainingApplication.class, args);

	}
	@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}





}
