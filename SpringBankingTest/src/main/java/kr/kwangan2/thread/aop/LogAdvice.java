package kr.kwangan2.thread.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {
	@AfterThrowing(
			pointcut = "execution(* kr.kwangan2.thread.service.BankingService*.*(..))"
			,throwing="e" //아래의 Exception 과 이름이 같아야한다.
	)
	public void logException(Exception e) {
		log.info("러닝 후 발생 했을 경우 -------- 발생한 예외 : "+e);
	}
}
