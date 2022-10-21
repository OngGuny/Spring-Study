package kr.co.kwhangan2;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
public class Pet {
	
	private String name;
	private int age;
}
