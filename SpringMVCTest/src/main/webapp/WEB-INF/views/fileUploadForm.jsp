<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> web-inf 안에 있는 폴더들은 url로 접근 할 수 없다. 설정파일들 다 있고 db접근파일도 다있다. 
<div>
<form name="frm" action="/test/fileupload" method="post" enctype="multipart/form-data">
	<input type="file" name="uploadFile" /><br />
	<input type="file" name="uploadFile" /><br />
	<input type="file" name="uploadFile" /><br />
	<input type="button" value="업로드" onclick="frm.submit();" />
</form>
</div>
</body>
</html>