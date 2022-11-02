package spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice{

	//이렇게 오버라이드 해놓으면 따로 위치 시킬 필요 없이 메인메소드 실행 전에 실행된다. 
	//before advice 로서 
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("앞에서 실행될 로직");
		
		
	}

}
