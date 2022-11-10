package kr.kwangan2.security.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class LoginSuccess implements AuthenticationSuccessHandler {
	@Override

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		// 여기는 받은 권한 확인하려고 하는거 실습에서는 필요없다 ㅎ;

		log.warn("Admin is coming Up");

		List<String> roleNames = new ArrayList<String>();

		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});

		log.warn("권한은 ? Role" + roleNames);
//		ROLE_ADMIN,ROLE_MEMBER_ADMIN,ROLE_BOARD_ADMIN
		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/jsp/adminMain");
			return;
		}

		if (roleNames.contains("ROLE_MEMBER_ADMIN")) {
			response.sendRedirect("/jsp/adminMain");
			return;
		}

		if (roleNames.contains("ROLE_BOARD_ADMIN")) {
			response.sendRedirect("/jsp/adminMain");
			return;
		}
		response.sendRedirect("/adminLogin");

	}// method

}// class
