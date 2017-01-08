package com.outlook.sftjun.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.outlook.sftjun.domain.User;

public class Json2Obj {
	public User json2User(String userJsonStr){
//		JSONObject jobj = JSON.parseObject(userJsonStr);
		User user = JSON.parseObject(userJsonStr,User.class);
		//注，这儿是调用了系统的set方法，所以如果返回的数据已经经过set处理，
		//密码已经加密，时间已经被设置为系统时间
		return user;
	}
}
