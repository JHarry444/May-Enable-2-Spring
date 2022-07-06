package com.qa.may;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.may.rest.DinoController;

@SpringBootApplication
public class MayEnable2ApiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MayEnable2ApiApplication.class, args);
		System.out.println("Found the bean: " + context.getBean(DinoController.class));
	}

}
