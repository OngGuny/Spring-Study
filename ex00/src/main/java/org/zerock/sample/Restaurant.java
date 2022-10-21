package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data

public class Restaurant {
 	
	@Setter(onMethod_  =@Autowired)//레스토랑에게 쉐프가 필요할때 자동으로 주겠다는것  
 	private Chef chef;
	
}
 