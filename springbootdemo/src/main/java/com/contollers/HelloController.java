package com.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.component.MyComponent;

@Controller
@RequestMapping("/")
public class HelloController {
	
	@Autowired
	private MyComponent myComp;
	
	@RequestMapping(value = "sayHello",method = RequestMethod.GET)
	public String sayHello() {
		myComp.addUser(); 
		return "welcome";
	}

	public MyComponent getMyComp() {
		return myComp;
	}

	public void setMyComp(MyComponent myComp) {
		this.myComp = myComp;
	}
}
