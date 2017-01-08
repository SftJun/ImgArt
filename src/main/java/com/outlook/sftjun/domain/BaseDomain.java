package com.outlook.sftjun.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8056044465410117729L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
