package com.cc.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.cc.springboot.test01.userMapper01;
import com.cc.springboot.test02.userMapper02;
import com.cc.springboot.util.JsonResponse;



@Service
public class userService 
{
	@Autowired
	private userMapper01 userMapper01;
	@Autowired
	private userMapper02 userMapper02;
	
	@Transactional
	public JSONObject insertUser(String name1,Integer age1,String name2,Integer age2)
	{
		System.out.println("开始service层");
		JSONObject result = JsonResponse.success();
	    System.out.println("开始插入1");
		//JsonResponse.putIntoBody(result, userMapper01.insertUser1(name1, age1));
	    userMapper01.insertUser1(name1, age1);
	   
	    
		System.out.println("结束插入1");
		System.out.println("开始插入2");
		//JsonResponse.putIntoBody(result,userMapper02.insertUser2(name2, age2));
		userMapper02.insertUser2(name2, age2);
		System.out.println("结束插入2");
		System.out.println("结束service层");
		return result;
		
	}

	

}
