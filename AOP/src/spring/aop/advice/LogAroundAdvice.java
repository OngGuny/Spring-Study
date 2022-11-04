package spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;//얘 주의
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		long start = System.currentTimeMillis();//실제업무담당메소드 바로위에서 실행
		System.out.println("Around - start advice");
		
		
	Object result =	invocation.proceed();
		

		
		long end = System.currentTimeMillis();
		String message = (end - start) + "ms 시간이 걸렸습니다";
		System.out.println(message);
		System.out.println("Around - end advice");

		
		return result;
	}

}//class
