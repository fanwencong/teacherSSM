package com.xtc.bean.teacher;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;



/***
 * @author 范文聪
 * @date 2016-8-9
 **/
public class Teacher {
	
	//教师ID
	private String id;
	//教师姓名
	@NotEmpty(message="姓名不能为空")
	private String name;
	//登录密码
	@NotEmpty(message="密码不能为空")
	private String password;
	//性别
	@Pattern(regexp="[男女]",message="只能为男或者女,且不能为空")
	private String sex;
	//个人简历
	@NotEmpty(message="个人简介不能为空")
	private String description;
	//头像URL
	@NotEmpty(message="头像Url不能为空")
	private String picUrl;
	//学校名称
	@NotEmpty(message="学校名称不能为空")
	private String schoolName;
	//注册时间
	private Date registDate;
	//备注
	private String remark;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
