<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FileUpload</title>
</head>
<body>
<form action="write.do" method="post" enctype="multipart/form-data" onsubmit="return formCheck();">
	제목 : <input type="text" name="title" /><br/>
	작성자 : <input type="text" name="writer" /><br/>
	내용 : <textarea rows="10" cols="20" name="content"></textarea><br/>
	파일 : <input type="file" name="filename"> <input type="submit" value="upload"/>
</form> 

</body>
</html>