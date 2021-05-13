package annotationIntro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component
@Component("test")
public class Test {
	
	@Autowired
	@Qualifier("myService")
	private ParentService myService;
	
	public ParentService getMyService() {
		return myService;
	}
	public void setMyService(ParentService myService) {
		this.myService = myService;
	}
	
	public void doBussiness() {
		myService.doService();
	}
}

interface ParentService{
	public void doService();
}

@Service
class MyService implements ParentService{
	
	@Autowired
	private MyRepoDAO myrepo;
	public MyRepoDAO getMyrepo() {
		return myrepo;
	}
	public void setMyrepo(MyRepoDAO myrepo) {
		this.myrepo = myrepo;
	} 
	
	@Override
	public void doService() {
		System.out.println("Service method called...");
		myrepo.access();
		
	}
	
}
@Service("myServiceTwo")
class MyService2 implements ParentService{
	
	@Autowired
	private MyRepoDAO myrepo;
	public MyRepoDAO getMyrepo() {
		return myrepo;
	}
	public void setMyrepo(MyRepoDAO myrepo) {
		this.myrepo = myrepo;
	} 
	
	@Override
	public void doService() {
		System.out.println("Service 2 method called...");
		myrepo.access();
		
	}
	
}

@Repository
class MyRepoDAO{
	public void access() {
		System.out.println("Repo DAO called...");
	}
}