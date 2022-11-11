package kr.kwangan2.security.mapper;

import kr.kwangan2.security.domain.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userid);
}
