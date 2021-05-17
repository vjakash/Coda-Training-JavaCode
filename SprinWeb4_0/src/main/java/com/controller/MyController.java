package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.LoginForm;
import com.service.UserService;

@Controller
@RequestMapping("/")
public class MyController {

	@Autowired
	private UserService userService;

	public final UserService getUserService() {
		return userService;
	}

	public final void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="doBusiness", method=RequestMethod.GET)
	public void doBusiness() {
		LoginForm loginForm=new LoginForm();
		loginForm.setUid(100);
		loginForm.setUname("ramu");
		loginForm.setUpass("spider");
		userService.createUser(loginForm);
	}
}
