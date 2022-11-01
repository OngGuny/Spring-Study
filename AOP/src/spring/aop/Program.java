package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

public class Program {

	public static void main(String[] args) {

		ApplicationContext context = 
				//new AnnotationConfigApplicationContext(NewlecDIconfig.class);
				new ClassPathXmlApplicationContext("/spring/aop/setting.xml");
				//classapth 로 생성해서 해야 할 일.
		/*1. 순수이그잼
		 * 2. 프록시 만들기
		 * 3. 곁다리 업무 만들기. 크로스 커터 
		 * */
		//이렇게 하면 결합관계를 설정에서(xml) 자유롭게 바꿀 수 있음
		Exam proxy = (Exam) context.getBean("exam");
		System.out.printf("total is %d\n", proxy.total());
		System.out.printf("avg is %f\n", proxy.avg());

		// 곁다리 업무 없다. 순수 이그잼
//		Exam exam = new NewlecExam(1, 1, 1, 1);

		// 얘는 이그잼이랑 똑같은데 곁다리 업무를 포함하고 있는 애다.
//		Exam proxy = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(), new Class[] { Exam.class }, new InvocationHandler() {
//
//			@Override
//			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				long start = System.currentTimeMillis();//실제업무담당메소드 바로위에서 실행
//				
//				
//				Object result = method.invoke(exam, args); //호출한 메소드의 인자를 args에
//								//	여기는 맨 위의 이그잼
//				
//				try {
//					Thread.sleep(200);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				long end = System.currentTimeMillis();
//				String message = (end - start) + "ms 시간이 걸렸습니다";
//				System.out.println(message);
//
//				return result;
//			}
//		
//		});// 맨 마지막은 곁다리 업무를 꽂을 수 있는 공간 // 클래스 안만들고 그냥 익명인터페이스 구현함
//		// d뉴렉이그잼이 여러개의 인터페이스를 들고 있을 경우 뒤의 인터페이스 파라미터 칸에서
//		// 그 인터페이스들을 배열로 표시해 주는것
//		System.out.printf("total is %d\n", proxy.total());
//		System.out.printf("avg is %f\n", proxy.avg());

	}// main

}// class
