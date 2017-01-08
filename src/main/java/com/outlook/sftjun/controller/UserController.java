package com.outlook.sftjun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.outlook.sftjun.domain.User;
import com.outlook.sftjun.service.UserService;
import com.outlook.sftjun.tools.EncryptionTools;
import com.outlook.sftjun.tools.Json2Obj;
import com.outlook.sftjun.tools.U8JsonDecoder;

@Controller
@RequestMapping("/user") // 正理来自/userURI的请求
@SessionAttributes("user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}

	@ResponseBody
	@RequestMapping(value="hello")
	public String sayHello(){
		return toJsonString(new User());
	}
	
	@ResponseBody
	@RequestMapping(value="save",method = RequestMethod.POST)
	public String saveJson(@RequestBody String jsonString){
		System.out.println("Starting...........");
		System.out.println(new U8JsonDecoder().decoderU8Json(jsonString));
		System.out.println(jsonString);
		User user = new Json2Obj().json2User(new U8JsonDecoder().decoderU8Json(jsonString));
		System.out.println(user);
		System.out.println("Ending...........");
		return "Hello";
	}
	
	@ResponseBody
	@RequestMapping(value="saveuser",method = RequestMethod.POST)
	public String saveUser(@RequestBody String userJsonStr){
		String flag = "failed";
		System.out.println(userJsonStr);
		String encoderJson = new U8JsonDecoder().decoderU8Json(userJsonStr);
		System.out.println(encoderJson);
		User user = new Json2Obj().json2User(encoderJson);
		if(userService.saveUser(user)){
			flag = JSON.toJSONString(userService.findUserByName(user.getUserName()));
		}
		return flag;
	}
	
	@ResponseBody
	@RequestMapping(value="finduser",method = RequestMethod.POST)
	public String findUser(@RequestBody String userJsonStr){
		System.out.println(userJsonStr);
		String encoderJson = new U8JsonDecoder().decoderU8Json(userJsonStr);
		System.out.println(encoderJson);
		User jsonUser = new Json2Obj().json2User(encoderJson);
		System.out.println(jsonUser.getPassword());
		System.out.println(jsonUser);
		User tmpUser = userService.findUserByName(jsonUser.getUserName());
		String newPass = jsonUser.getPassword();
		System.out.println("New:"+newPass);
		String oldPass = tmpUser.getPassword();
		System.out.println("Old:"+oldPass);
		if((newPass == oldPass)||(newPass.equals(oldPass))){
			return toJsonString(tmpUser);
		}
		else{
			System.out.print("Failed");
			return "failed";
		}
	}
	
	@RequestMapping(value="register")
	public String registerUser(){
		return "/user/register";
	}
}
