package com.wmr.mybatis.entity;

import java.util.List;

public class Classes {
	private int id;
	private String name;
	private List<Student> sutdent;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getSutdent() {
		return sutdent;
	}
	public void setSutdent(List<Student> sutdent) {
		this.sutdent = sutdent;
	}	
}
