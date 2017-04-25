package com.example.address.entity;

import java.io.Serializable;

public class Region implements Serializable{

	private int id;
	private int pid;
	private int type;
	private int baomingstatus;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getBaomingstatus() {
		return baomingstatus;
	}
	public void setBaomingstatus(int baomingstatus) {
		this.baomingstatus = baomingstatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
