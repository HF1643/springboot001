package com.cc.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cc.springboot.service.userService;

@RestController
public class userControler 
{

	@Autowired
	private  userService userService;
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject insertUser(String name1,Integer age1,String name2,Integer age2)
	{
		JSONObject object = null;
		System.out.println("开始control层");
		try 
		{
			object= userService.insertUser(name1, age1, name2, age2);
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			
			
		}
		System.out.println("结束control层");
		
		return object;
		
		
	}
	@RequestMapping("/cs")
	@ResponseBody
	public String test()
	{
		return "测试";
	}
	
	
}
