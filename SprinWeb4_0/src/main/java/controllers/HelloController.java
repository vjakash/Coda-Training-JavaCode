package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class HelloController {

	@RequestMapping(value="hai",method = RequestMethod.GET)
	public void met1() {
		System.out.println("Hello met1 called...");
	}
	
	@RequestMapping(value="hai2",method = RequestMethod.GET)
	public String met2() {
		System.out.println("Hello met2 called...");
		return "welcome";
	}
	
	@RequestMapping(value="hai3",method = RequestMethod.GET)
	public ModelAndView met3() {
		System.out.println("Hello met2 called...");
		ModelAndView mandv=new ModelAndView();
		mandv.setViewName("welcome");
		mandv.addObject("msg", "Message from hello met 3.....Spring MVC....");
		return mandv;
	}
	
	@RequestMapping(value="hai4",method = RequestMethod.GET)
	public ModelAndView met4(ModelAndView mandv) {
		mandv.setViewName("welcome");
		mandv.addObject("msg", "Message from hello met 4.....Spring MVC....");
		return mandv;
	}
	
	@RequestMapping(value="hai5",method = RequestMethod.GET)
	public ModelAndView met5(ModelAndView mandv,HttpServletRequest request) {
		mandv.setViewName("welcome");
		mandv.addObject("msg", "Message from hello met 4.....Spring MVC....");
		request.setAttribute("msg2", "This is message two");
		return mandv;
	}
	
	@RequestMapping(value="hai6/{uname}",method = RequestMethod.GET)
	public ModelAndView met6(ModelAndView mandv,HttpServletRequest request,@PathVariable("uname") String uname) {
		mandv.setViewName("welcome");
		System.out.println("The path variable is :"+uname);
		mandv.addObject("msg", "Message from hello met 4.....Spring MVC....");
		request.setAttribute("msg2", "This is message two......"+uname);
		employee.doBussiness();
		return mandv;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Autowired
	private Employee employee;
	
}

@Component
class Employee{
	@Autowired
	private MyService myService;

	public MyService getMyService() {
		return myService;
	}

	public void setMyService(MyService myService) {
		this.myService = myService;
	}
	public void doBussiness() {
		System.out.println("Do bussiness method called....");
		myService.doService();
	}
}

@Service
class MyService{
	@Autowired
	private MyRepo myRepo;

	public MyRepo getMyRepo() {
		return myRepo;
	}

	public void setMyRepo(MyRepo myRepo) {
		this.myRepo = myRepo;
	}
	public void doService() {
		System.out.println("Do service method called.....");
		myRepo.findAll();
	}
}
@Repository
class MyRepo{
	public void findAll() {
		System.out.println("All employee records found....");
	}
}