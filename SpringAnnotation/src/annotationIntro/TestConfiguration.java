package annotationIntro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {


	@Bean(name = {"test"})
	@Autowired
	public Test getTest() {
		return new Test();
	}
	
	@Bean
	@Autowired
	@Qualifier("myService")
	public ParentService getService1() {
		return new MyService();
	}
	@Bean
	public MyRepoDAO getRepo() {
		return new MyRepoDAO();
	}
}
