package spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice{
	//얘는 구현할게 없네? 
	//정해 질 수가 없다. 다른애들은 인자가 고정되있다. 
	//얘는 어떤 예외가 나오느냐에 따라 인자가 달라지기때문에 고정 시킬 수가 없다. 
	//일단 기본적인 틀  				인자의 오류형태는 원래 정해지지 않았다. 어떤 예외처리할꺼냐 따라서 인자 달라짐
	 public void afterThrowing(IllegalArgumentException e ) throws Throwable {
		 
	 }
	
}//class
