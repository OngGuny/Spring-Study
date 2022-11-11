package kr.kwangan2.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.kwangan2.security.domain.CustomUser;
import kr.kwangan2.security.domain.MemberVO;
import kr.kwangan2.security.mapper.MemberMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{

	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mbMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info(username);
		
		MemberVO vo = mbMapper.read(username);
		
	
		return vo == null?null:new CustomUser(vo);
	}
	//아까 만든 우리 매퍼를 사용해라 그뿐. 딲 여기까지만 하면됨

}
