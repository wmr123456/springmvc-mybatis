package com.wmr.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wmr.mybatis.entity.Classes;

public interface ClassesMapper {
	@Insert("insert into classes (name) values (#{name})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public void insertClasses(Classes classes);
	
	@Select("select * from classes where id=(#{id})")
	@Results({
		@Result(id=true, property="id",column="id", javaType=Integer.class),
		@Result(property="name", column="name", javaType=String.class),
		@Result(property="sutdent",column="id",javaType=List.class,
		many=@Many(select="com.wmr.mybatis.mapper.StudentMapper.selectStudentByClass"))
	})
	public Classes selectClasses(int id);
	
	@Delete("delete from classes where id=#{id}")
	public void deleteClasses(int id);
}
