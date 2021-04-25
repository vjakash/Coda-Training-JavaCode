package sprintransaction;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {
	
	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("transaction_config.xml");
		
		BusinessBean bb=ctx.getBean("businessadvisedbean",BusinessBean.class);
		
		bb.doTransaction(2,1,2000);
	
	}
}
