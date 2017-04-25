package com.example.address.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_address")
public class Address implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	@Id
	private int id;
	private int pid;
	private String type;
	private String name;
	@Transient
	private String remark;
	
	
	public Address() {
		super();
	}
	
	public Address(int id, String type, String name) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
	}
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", pid=" + pid + ", type=" + type + ", name=" + name + ", remark=" + remark + "]";
	}


	
}
