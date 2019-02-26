/**
 * 
 */
package com.codingtest.addressbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ROHAN-PC
 *
 */

@Configuration
@ComponentScan(basePackages = "com.codingtest.addressbook.*")
@PropertySource(value="classpath:application.properties")
public class AddressBookConfig implements WebMvcConfigurer{

	@Bean 
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}
}

