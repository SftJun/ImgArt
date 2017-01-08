package com.outlook.sftjun.controller;

import com.alibaba.fastjson.JSON;


public class BaseController implements IBaseController {
	/**
	 * @see com.outlook.sftjun.controller.IBaseController#toJsonString(java.lang.Object)
	 */
	public String toJsonString(Object obj) {
		return JSON.toJSONString(obj);
	}
}
