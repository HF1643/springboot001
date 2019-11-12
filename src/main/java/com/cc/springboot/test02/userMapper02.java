package com.cc.springboot.test02;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface userMapper02 
{

	
	@Insert("<script>"	
			+"INSERT into user (name2,age2) "
			+ "VALUES"
			+ "(#{name2},#{age2})"
			+"</script>")
	int insertUser2(@Param("name2") String  name2,
			        @Param("age2")  Integer age2
 			);
	
}
