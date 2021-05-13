package annotationAdvice;

import org.springframework.stereotype.Component;

//@Component("testFunctions")
public class AnnotationAdviceTest implements AdviceIntroFuncs{

	@Override
	public void addCustomer() {
		System.out.println("addCustomer() is running ");

		
	}

	@Override
	public String addCustomerReturnValue() {
		System.out.println("addCustomerReturnValue() is running ");
		return "abc";
	}

	@Override
	public void addCustomerThrowException() throws Exception {
		System.out.println("addCustomerThrowException() is running "); 
		throw new Exception("Generic Error");

		
	}

	@Override
	public void addCustomerAround(String name) {
		System.out.println("addCustomerAround() is running, args : " +name);
		
	}

}
