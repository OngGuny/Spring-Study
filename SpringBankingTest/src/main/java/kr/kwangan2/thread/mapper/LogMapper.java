package kr.kwangan2.thread.mapper;

import org.apache.ibatis.annotations.Insert;

public interface LogMapper {

	@Insert(" insert into bankinglog(순번, 입금자, 출금자, 금액, 입출금상태, 입출금일시) "
			+ "values (seq_logging.nextval, '영희', '철수', #{money},#{stat}, sysdate ) ")
	public String insertLog(String money, String stat);
	
}//
