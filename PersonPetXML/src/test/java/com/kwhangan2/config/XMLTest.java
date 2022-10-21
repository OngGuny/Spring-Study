package com.kwhangan2.config;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class XMLTest { // 이거할때는 플러그인 xml 셋팅해줘야함.
	@Setter(onMethod_ = {@Autowired})
	private Person person;
	
	
	
	@Setter(onMethod_ = {@Autowired})
	private Pet pet;
	
	@Test
	public void testExist() {
		assertNotNull(person);
		assertNotNull(pet);
		
		person.setAge(20);
		person.setName("KillDong");
		//person.getPet();
//		person.getPet().setAge(5);;
//		person.getPet().setName("Happy");
		pet.setAge(5);
		pet.setName("dd");
		log.info(person);
		log.info(person.getAge()+"살 인  "+person.getName()+"이  "+person.getPet().getAge()+"살 인  "+person.getPet().getName()+"를 키웁니다!");

	}
	
}
