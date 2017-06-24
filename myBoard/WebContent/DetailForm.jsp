<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.esp.board.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Article article = (Article)request.getAttribute("article");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function FileDownlad(){
	var filename = document.getElementsByName("filename")[0].value;
	location.href = "download.do?filename=" + filename;
}

function Cancle() {
	location.href = "list.do";
}
</script>
<title></title>
</head>
<body>
<table>
	<tr>
	    <td colspan="2"> 제 목 <input type="text" name="title" size="60" value="<%=article.getTitle() %>" /></td>
	    <td></td>
	</tr>
	<tr>
	    <td colspan="2">
	        <textarea name="content" rows="30" cols="65"><%=article.getContent() %></textarea>
	    </td>
	</tr>
	<tr>
		<td>
			<input type="text" name="filename" value="<%=article.getPath() %>" disabled="true" size="50">
			<input type="button" value="다운로드" onclick="javascript:FileDownlad()">
		</td>
		<td>
			<input type="reset" value="취소" onclick="javascript:Cancle()">
		</td>
	</tr>
	<tr>
	    <td colspan="2">
	        
	    </td>
	</tr>
</table>
</body>
</html>