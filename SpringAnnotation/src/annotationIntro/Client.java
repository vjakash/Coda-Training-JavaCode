package annotationIntro;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
//		ConfigurableApplicationContext ctx =new ClassPathXmlApplicationContext("config.xml");
		ConfigurableApplicationContext ctx=new AnnotationConfigApplicationContext(TestConfiguration.class);
		
		Test test=ctx.getBean("test",Test.class);
		System.out.println(test);
		test.doBussiness();
	}
}
