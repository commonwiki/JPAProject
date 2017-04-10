package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "plan_2014")
public class Plan {

	@Id
	private int id;
	private String name;//联系人
	private String mobile;//手机
	private String tel;//电话
	private String email;//邮箱
	private String fax;//传真

	private String ac1; // 项目名称
	private String ac3; // 公司名称
	private String ac5; // 所处行业
	private String ac4; // 成立时间 所处阶段
	
	private String alc2; // 目前的投资人
	private String alc1; // 融资计划
	private String alc7; // 项目亮点
	private String alc3; // 项目简介
	private String alc4; // 商业模式及收入来源 股权结构
	private String alc5; // 市场分析
	private String alc6; // 项目团队
	
	
	private String ac6; // 优势
	private String ac7; // 劣势
	private String ac8; // 机会
	private String ac9; // 威胁

	// 财务数据
	private String ac10;
	private String ac11;
	private String ac12;
	private String ac13;
	private String ac15;
	private String ac18;
	private String ac19;
	private String ac21;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAc1() {
		return ac1;
	}

	public void setAc1(String ac1) {
		this.ac1 = ac1;
	}

	public String getAc3() {
		return ac3;
	}

	public void setAc3(String ac3) {
		this.ac3 = ac3;
	}

	public String getAc5() {
		return ac5;
	}

	public void setAc5(String ac5) {
		this.ac5 = ac5;
	}

	public String getAc4() {
		return ac4;
	}

	public void setAc4(String ac4) {
		this.ac4 = ac4;
	}

	public String getAlc2() {
		return alc2;
	}

	public void setAlc2(String alc2) {
		this.alc2 = alc2;
	}

	public String getAlc1() {
		return alc1;
	}

	public void setAlc1(String alc1) {
		this.alc1 = alc1;
	}

	public String getAlc7() {
		return alc7;
	}

	public void setAlc7(String alc7) {
		this.alc7 = alc7;
	}

	public String getAlc3() {
		return alc3;
	}

	public void setAlc3(String alc3) {
		this.alc3 = alc3;
	}

	public String getAlc4() {
		return alc4;
	}

	public void setAlc4(String alc4) {
		this.alc4 = alc4;
	}

	public String getAlc5() {
		return alc5;
	}

	public void setAlc5(String alc5) {
		this.alc5 = alc5;
	}

	public String getAlc6() {
		return alc6;
	}

	public void setAlc6(String alc6) {
		this.alc6 = alc6;
	}

	public String getAc6() {
		return ac6;
	}

	public void setAc6(String ac6) {
		this.ac6 = ac6;
	}

	public String getAc7() {
		return ac7;
	}

	public void setAc7(String ac7) {
		this.ac7 = ac7;
	}

	public String getAc8() {
		return ac8;
	}

	public void setAc8(String ac8) {
		this.ac8 = ac8;
	}

	public String getAc9() {
		return ac9;
	}

	public void setAc9(String ac9) {
		this.ac9 = ac9;
	}

	public String getAc10() {
		return ac10;
	}

	public void setAc10(String ac10) {
		this.ac10 = ac10;
	}

	public String getAc11() {
		return ac11;
	}

	public void setAc11(String ac11) {
		this.ac11 = ac11;
	}

	public String getAc12() {
		return ac12;
	}

	public void setAc12(String ac12) {
		this.ac12 = ac12;
	}

	public String getAc13() {
		return ac13;
	}

	public void setAc13(String ac13) {
		this.ac13 = ac13;
	}

	public String getAc15() {
		return ac15;
	}

	public void setAc15(String ac15) {
		this.ac15 = ac15;
	}

	public String getAc18() {
		return ac18;
	}

	public void setAc18(String ac18) {
		this.ac18 = ac18;
	}

	public String getAc19() {
		return ac19;
	}

	public void setAc19(String ac19) {
		this.ac19 = ac19;
	}

	public String getAc21() {
		return ac21;
	}

	public void setAc21(String ac21) {
		this.ac21 = ac21;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
