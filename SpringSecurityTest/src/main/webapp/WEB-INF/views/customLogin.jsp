<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<h1>Custom Login PagE</h1>
	<h2>${error }</h2>
	<h2>${logout }</h2>
	
	<form method="post" action="/login"><br />
		<input type="text" name="username" value="admin90" /><br />
		<input type="password" name="password" value="pw90" /><br />
		<input type="checkbox" name="remember-me" >자동 로그인<br />
		<input type="submit" /><br />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /><br />
	</form>
</div>

</body>
</html>