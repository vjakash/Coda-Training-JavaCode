package annotationAdvice;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		AdviceIntroFuncs aat=ctx.getBean("testFunctions",AdviceIntroFuncs.class);
//		aat.addCustomer();
//		aat.addCustomerReturnValue();
//		try {
//			aat.addCustomerThrowException();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		aat.addCustomerAround("sample");
	}
}
