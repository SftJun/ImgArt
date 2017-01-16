package com.outlook.sftjun.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.outlook.sftjun.config.AppString;

@Controller
@RequestMapping(value="/index")
public class MainController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value="main")
	public String main(HttpSession httpSession){
		log.info(httpSession.getAttribute(AppString.SESSION_USER_ID).toString());
		log.debug("Main Request");
		return "/imgs/main";
	}
}
