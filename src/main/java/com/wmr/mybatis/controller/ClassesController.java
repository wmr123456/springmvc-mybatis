package com.wmr.mybatis.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wmr.mybatis.entity.Classes;
import com.wmr.mybatis.mapper.ClassesMapper;

@Controller
@RequestMapping("classes")
public class ClassesController {
	@Autowired
	ClassesMapper classesMapper;
	
	ObjectMapper objectMapper = new ObjectMapper();
	@RequestMapping("getClassByClassid")
	@ResponseBody
	public String getClassesByClassId(@RequestParam int id) {
		String result = null;
		Classes classes = null;
		classes = classesMapper.selectClasses(id);
		System.out.println(classes.getId());
		System.out.println(classes.getSutdent());
		
		try {
			result = objectMapper.writeValueAsString(classes);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
