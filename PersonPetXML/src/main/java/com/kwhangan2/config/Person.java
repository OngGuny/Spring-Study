package com.kwhangan2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@ToString
@Component
@Data
public class Person {
	private String name;
	private int age;
	
	@Setter(onMethod_=@Autowired)
	private Pet pet;
	
	
}
