package com.cg.beans;

public class Student {
	private int id;
	private String name, email;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Name: "+name+" ID: "+id+" Email: "+email);
		
	}

}
