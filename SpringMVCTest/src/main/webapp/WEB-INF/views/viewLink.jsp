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
		<a href="/test/test1">/test/test1(get)</a><br />
		<form name="frm1" action="/test/test1" method="get">
			<input type="button" value="/test/test1(get)"
				onclick="frm1.submit();" />
		</form>
		<a href="/test/test2">/test/test2(post)</a><br />
		<form name="frm2" action="/test/test2" method="post">
			<input type="button" value="/test/test2(post)"
				onclick="frm2.submit();" />
		</form>
	</div>

</body>
</html>