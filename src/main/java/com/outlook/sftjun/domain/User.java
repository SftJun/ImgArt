package com.outlook.sftjun.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.outlook.sftjun.tools.EncryptionTools;

/**
 * @Title:Entity
 * @Description:用户信息
 * @author YinJun
 * @date 2016-05-26
 * @version V1.0
 *
 */
@Entity
@Table(name="t_user")
@DynamicInsert(true)
@DynamicUpdate(true)
public class User extends BaseDomain{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7345987306058194512L;
	/**
	 * ID
	 */
	@Id
	@Column(name = "ID",length=32)
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	private String id;
	/**
	 * 用户名
	 */
	@Column(name="USERNAME",unique=true,nullable=false,length=20)
	private String userName;
	/**
	 * 密码
	 */
	@Column(name="PASSWORD",nullable=false,length=32)
	private String password;
	/**
	 * 性别
	 */
	@Column(name="GENDER",length=2)
	private String gender;
	/**
	 * 年龄
	 */
	@Column(name="AGE")
	private Integer age;
	/**
	 * 电话
	 */
	@Column(name="TEL",length=11)
	private String tel;
	/**
	 * 注册时间
	 */
	@Column(name="REGISTER_TIME",nullable=false)
	private Timestamp registerTime = new Timestamp((new Date()).getTime());
	
	/**
	 * ID
	 * @return
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 用户名
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置密码，并对密码进行MD5加密
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = EncryptionTools.MD5(password);
	}
	/**
	 * 性别
	 * @return
	 */
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 年龄
	 * @return
	 */
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 电话
	 * @return
	 */
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 注册时间
	 * @return
	 */
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
}
