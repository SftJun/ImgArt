package com.outlook.sftjun.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**
 * @Title:Entity
 * @Description:图片信息
 * @author YinJun
 * @date 2016-11-16
 * @version V1.0
 *
 */
@Entity
@Table(name = "t_img")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Img extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8382352340172703146L;

	/**
	 * ID
	 */
	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	/**
	 * 图片名称
	 */
	@Column(name = "IMG_NAME", unique = true, nullable = false, length = 50)
	private String imgName;
	
	/**
	 * 图片位置
	 */
	@Column(name = "IMG_URL", nullable = false)
	private String imgUrl;
	/**
	 * 图片类型
	 */
	@Column(name = "IMG_TYPE", nullable = false)
	private String contentType;
	/**
	 * 上传时间
	 */
	@Column(name = "IMG_UP_TIME", nullable = false)
	private Timestamp upTime = new Timestamp((new Date()).getTime());
	/**
	 * 图片拍摄地点
	 */
	@Column(name = "IMG_LOCATION")
	private String location;
	/**
	 * 图片简介
	 */
	@Column(name = "IMG_SHORT_INFO")
	private String shortInfo;
	/**
	 * 用户
	 */
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Timestamp getUpTime() {
		return upTime;
	}

	public void setUpTime(Timestamp upTime) {
		this.upTime = upTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getShortInfo() {
		return shortInfo;
	}

	public void setShortInfo(String shortInfo) {
		this.shortInfo = shortInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
