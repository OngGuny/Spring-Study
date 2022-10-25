package mybatis.test.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable{
	private static final long serialVersionUID = 23423452345L;
	
	private int sid;
	private String email;
	private String name;
	private String passwd;
	
	
	
	
	
	}
