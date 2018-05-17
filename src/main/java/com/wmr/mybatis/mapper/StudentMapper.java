package com.wmr.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wmr.mybatis.entity.Classes;
import com.wmr.mybatis.entity.Student;

public interface StudentMapper {
	@Insert("insert into student (name, classes_id) values (#{name}, #{classes_id}")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public void insertStudent(Student student);
	
	@Select("select * from student where id=#{id}")
	@Results({
		@Result(id=true, property="id", column="id", javaType=Integer.class),
		@Result(property="name", column="name",javaType=String.class),
		@Result(property="classes",column="classes_id",javaType=Classes.class,
		one=@One(select="com.wmr.mybatis.mapper.ClassesMapper.selectClasses"))
	})
	public Student selectStudent(int id);
	
	@Select("select * from student where classes_id=#{classes_id}")
	@Results({
		@Result(id=true, property="id", column="id", javaType=Integer.class),
		@Result(property="name", column="name",javaType=String.class),
		@Result(property="classId",column="classes_id",javaType=Integer.class)
		//one=@One(select="com.wmr.mybatis.mapper.ClassesMapper.selectClasses")要配置多对一在实体类中将classId的类型改为classes实体类类型。
	})
	public List<Student> selectStudentByClass(@Param("classes_id")int classId);
	
	@Delete("delete student where id=#{id}")
	public void deleteStudent(int id);
}

