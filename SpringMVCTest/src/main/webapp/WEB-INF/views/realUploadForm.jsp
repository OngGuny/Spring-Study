<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div> 애를 불러주는 컨트롤러랑 밑의 액션 처리하는 컨트롤러 2개 필요함 
<form name="frm" action="/test/realfileupload" method="post" enctype="multipart/form-data">
	<input type="file" name="uploadFile" /><br />
	<input type="file" name="uploadFile" /><br />
	<input type="file" name="uploadFile" /><br />
	<input type="button" value="업로드" onclick="frm.submit();" />
</form>
</div>
</body>
</html>