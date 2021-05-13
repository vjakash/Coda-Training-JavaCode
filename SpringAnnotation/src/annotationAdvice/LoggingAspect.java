package annotationAdvice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(* annotationAdvice.AdviceIntroFuncs.addCustomer(..))") 
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("logBefore() is running!");
		System.out.println("Inside before : " +joinPoint.getSignature().getName()); 
		System.out.println("******");
	}
	
	@After("execution(* annotationAdvice.AdviceIntroFuncs.addCustomer(..))") 
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("logAfter() is running!");
		System.out.println("Inside After : " +joinPoint.getSignature().getName());
		System.out.println("******");
	}
	
	@AfterReturning(pointcut = "execution(* annotationAdvice.AdviceIntroFuncs.addCustomerReturnValue(..))",returning= "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
			System.out.println("logAfterReturning() is running!"); 
			System.out.println("Inside after returning : " +joinPoint.getSignature().getName());
			System.out.println("Method returned value is : " + result); 
			System.out.println("******");
	}
	
	@AfterThrowing(pointcut = "execution(* annotationAdvice.AdviceIntroFuncs.addCustomerThrowException(..))", throwing= "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("logAfterThrowing() is running!");
		System.out.println("Inside After Throwing-excep: " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******"); 
	}
	
	@Around("execution(* annotationAdvice.AdviceIntroFuncs.addCustomerAround(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("logAround() is running!");
		System.out.println("Around method : " + joinPoint.getSignature().getName());
		System.out.println("Around Method arguments : " + Arrays.toString(joinPoint.getArgs()));
		
		System.out.println("Around before is running!");
		joinPoint.proceed(); //continue on the intercepted method 
		System.out.println("Around after is running!"); 
		System.out.println("******");
	}

}
