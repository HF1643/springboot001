package com.cc.springboot.test01;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface userMapper01 
{

	@Insert("<script>"	
			+"INSERT into user (name1,age1) "
			+ "VALUES"
			+ "(#{name1},#{age1})"
			+"</script>")
	int insertUser1(@Param("name1") String name1,
			        @Param("age1")  Integer age1
 			);

}
