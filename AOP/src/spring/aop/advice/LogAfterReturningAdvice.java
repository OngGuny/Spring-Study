package spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfterReturningAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
										//필요하면 이 반환값 쓰라는거. return 없음.
		System.out.println("에프터 러닝이에요~ returnValue: "+returnValue+", method:"+method.getName());
	}

	
}
