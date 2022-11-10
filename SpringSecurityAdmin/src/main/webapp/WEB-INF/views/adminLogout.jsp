<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogOUt PagE</title>
</head>
<body>
<form action="/adminLogin" method="post">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
	<button>로그 아웃 </button>
</form>
</body>
</html>