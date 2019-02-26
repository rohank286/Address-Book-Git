package com.codingtest.addresbook.testcases;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.codingtest.addressbook.repo.AddressBookRepo;
import com.codingtest.addressbook.service.AddressBookService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.codingtest.addresbook.testcases.*","com.codingtest.addresbook.*"})
@EnableAspectJAutoProxy
public class AddressBookTestApplication implements WebMvcConfigurer{

	 @Bean
     public MethodValidationPostProcessor methodValidationPostProcessor() {
    	 return new MethodValidationPostProcessor();
     }
	 
	 @Bean
     public AddressBookService addressBookService() {
    	 return Mockito.mock(AddressBookService.class);
     }
	 
	 @Bean
     public AddressBookRepo addressBookRepoService() {
    	 return Mockito.mock(AddressBookRepo.class);
     }

}
