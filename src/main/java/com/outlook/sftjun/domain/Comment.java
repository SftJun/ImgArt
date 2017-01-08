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
 * @Description:评论信息
 * @author YinJun
 * @date 2016-11-16
 * @version V1.0
 *
 */
@Entity
@Table(name="t_comment")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Comment extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5895324398692192308L;

	/**
	 * ID
	 */
	@Id
	@Column(name = "ID",length=32)
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	private String id;
	/**
	 * 内容
	 */
	@Column(name = "COMMENT_CONTET",nullable=false,length=250)
	private String commContent;
	/**
	 * 评论时间
	 */
	@Column(name="COMMENT_TIME",nullable=false)
	private Timestamp commTime = new Timestamp((new Date()).getTime());
	/**
	 * 用户
	 */
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User commUser;
	/**
	 * 评论照片
	 */
	@ManyToOne
	@JoinColumn(name = "IMG_ID",nullable = false)
	private Img commImg;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCommContent() {
		return commContent;
	}
	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}
	public Timestamp getCommTime() {
		return commTime;
	}
	public void setCommTime(Timestamp commTime) {
		this.commTime = commTime;
	}
	public User getCommUser() {
		return commUser;
	}
	public void setCommUser(User commUser) {
		this.commUser = commUser;
	}
	public Img getCommImg() {
		return commImg;
	}
	public void setCommImg(Img commImg) {
		this.commImg = commImg;
	}	
}
