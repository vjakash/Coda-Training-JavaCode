package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import formBeans.LoginForm;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping(value="showLoginPage", method=RequestMethod.GET)
	public ModelAndView showLoginPage(ModelAndView mandv) {
		LoginForm loginForm=new LoginForm();
		mandv.addObject("loginBean",loginForm);
		mandv.setViewName("login");
		return mandv;
	}
	
	@RequestMapping(value="submitform", method=RequestMethod.POST)
	public ModelAndView processLoginPage(ModelAndView mandv,LoginForm loginForm) {
		System.out.println(loginForm.getUname()+":"+loginForm.getUpass());
		mandv.addObject("loginBean",loginForm);
		mandv.setViewName("welcome");
		return mandv;
	}
}
