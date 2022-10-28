package kr.kwangan2.mvc.domain;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PersonDTO {
	private String name;
	private int age;
	private ArrayList<PersonDTO> personDTOList;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 얘는 전체적으로 이렇ㄱ ㅔ적용시키는거
	private Date birth;

	public PersonDTO() {// 이 프라퍼티 하나에만 적용한다는거
		this.personDTOList = new ArrayList<PersonDTO>();
	}// %5B0%5D => 주소창에 이렇게뜨는거. [0] 이라는거.

}
