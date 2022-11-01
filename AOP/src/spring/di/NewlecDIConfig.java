package spring.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
//component-scan 대신할 어노테이셔ㅑㄴ
@ComponentScan("spring.di.ui")
//아래는 설정파일이라는것
@Configuration
public class NewlecDIConfig {
	// 뉴렉이그잼ㄷ도 ㄱㅊ지만 인터페이스 보내면 다른기능도 할 수 있으니깐.
	
	//이름을 이그잼으로 설정하는데. 이건 컨피그 파일 특
	public Exam exam() {
		return new NewlecExam();
	}
}//class
