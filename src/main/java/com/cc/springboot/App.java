package com.cc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.cc.springboot.config.DBConfig1;
import com.cc.springboot.config.DBConfig2;
@ComponentScan(basePackages = {"com.cc.springboot.config","com.cc.springboot.controller","com.cc.springboot.datasource","com.cc.springboot.entity","com.cc.springboot.service","com.cc.springboot.test01","com.cc.springboot.test02","com.cc.springboot.util"})
@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties(value = {DBConfig1.class,DBConfig2.class })
public class App {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		SpringApplication.run(App.class, args);
	}

}
