package annotationAdvice;

public interface AdviceIntroFuncs {
	void addCustomer();
	String addCustomerReturnValue();
	void addCustomerThrowException() throws Exception; 
	void addCustomerAround(String name);
}
