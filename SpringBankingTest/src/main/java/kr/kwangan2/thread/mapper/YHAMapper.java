package kr.kwangan2.thread.mapper;

import org.apache.ibatis.annotations.Insert;

public interface YHAMapper {

	@Insert(" insert into 영희A(Money) values (#{money})")
	public Long insertYHBanking(Long money);
}//
