package kr.kwangan2.thread.mapper;

import org.apache.ibatis.annotations.Insert;

public interface CSAMapper {

	@Insert(" insert into 철수A(Money) values (#{money})" )
	public Long insertCSBanking(Long money);
	
}//
