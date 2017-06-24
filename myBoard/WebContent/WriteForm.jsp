<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FileUpload</title>
</head>
<body>
<form action="write.do" method="post" enctype="multipart/form-data" onsubmit="return formCheck();">
<table>
	<tr>
	    <td colspan="2"> 
	    	제  목 <input type="text" name="title" size="60"/>
	    </td>
	</tr>
	<tr>
		<td colspan="2"> 
			작성자 <input type="text" name="writer" size="60"/>
		</td>
	</tr>
	<tr>
	    <td colspan="2">
	        내  용 <br><textarea name="content" rows="10" cols="65"></textarea>
	    </td>
	</tr>
	<tr>
		<td>
			파  일 <input type="file" name="filename"> <input type="submit" value="업로드"/>
		</td>
		<td>
			<input type="reset" value="취소" onclick="javascript:Cancle()">
		</td>
	</tr>
</table>
</form> 

</body>
</html>