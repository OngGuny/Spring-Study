package com.ex00javaconfig.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;



@Component
@Data
public class Restaurant {
 	
	@Setter(onMethod_=@Autowired)//�젅�뒪�넗�옉�뿉寃� �뎽�봽媛� �븘�슂�븷�븣 �옄�룞�쑝濡� 二쇨쿋�떎�뒗寃�  
 	private Chef chef;
	
}
 