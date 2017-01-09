package com.outlook.sftjun.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.outlook.sftjun.config.AppString;
import com.outlook.sftjun.domain.User;
import com.outlook.sftjun.domain.UserProperties;
import com.outlook.sftjun.service.UserService;
import com.outlook.sftjun.tools.EncryptionTools;
import com.outlook.sftjun.tools.Json2Obj;
import com.outlook.sftjun.tools.U8JsonDecoder;

@Controller
@RequestMapping("/user") // 正理来自/userURI的请求
@SessionAttributes("userId")
public class UserController extends BaseController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

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
	
	/**
	 * 请求注册页面
	 * @return
	 */
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String registerUserGet(){
		log.info("调用注册页面");
		return "/user/register";
	}
	
	/**
	 * 提交注册信息
	 * @param model
	 * @param httpServletRequest
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	public void registerUserPost(Model model,HttpServletRequest httpServletRequest){
		User user = new User();
		Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
		user.setUserName(parameterMap.get(UserProperties.USERNAME)[0]);
		user.setPassword(parameterMap.get(UserProperties.PASSWORD)[0]);
		user.setAge(Integer.parseInt(parameterMap.get(UserProperties.AGE)[0]));
		user.setGender(parameterMap.get(UserProperties.GENDER)[0]);
		user.setTel(parameterMap.get(UserProperties.TEL)[0]);
		userService.saveUser(user);
		log.info("用户注册成功");
		model.addAttribute(AppString.SESSION_USER_ID, 
				userService.findUserByName(user.getUserName()));
	}
}
