<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.esp.board.*" %>
<%@ page import="java.util.*" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<script type="text/javascript">
var check = false;
function CheckAll(){
	var allchk = document.getElementsByName("remove_all");
	var chk = document.getElementsByName("remove_unit");
	if(check == false){
		check = true;
		for(var i=0; i<chk.length;i++){                                                                    
			chk[i].checked = true;     //모두 체크
		}
		allchk.checked = true;
	} else {
		check = false;
		for(var i=0; i<chk.length;i++){                                                                    
			chk[i].checked = false;     //모두 해제
		}
		allchk.checked = false;
	}
}

function RemoveUnit(){
	
	var data = new Array();
	var j = 0;
	var chk = document.getElementsByName("remove_unit");
	var len = chk.length;
	for(var i = 0;i<len;++i) {
		if(chk[i].checked == true) {
			data[j++] = chk[i].value;
		}
	}
	
	location.href = "delete.do?unit=" + data;
}
</script>
</head>
<body style="font-size: 11px;">
<h1>목록</h1>
<%
List<Article> list = (List<Article>)request.getAttribute("list");
int totalCount = 3;
if(list != null)
	totalCount = list.size();
%>
<%=totalCount %>                
<form id="filelist" name="filelist" method="post">
	<table width='70%' cellpadding='5' cellspacing='0' border='1' align='center' style='border-collapse:collapse; border:1px gray solid;'>
		<tr>
			<td style='border:0px gray solid;'></td>
			<td style='border:0px gray solid;'></td>
			<td style='border:0px gray solid;'></td>
			<td style='border:0px gray solid;'><a href="" onclick="javascript:RemoveUnit()">삭제</a></td>
			<td style='border:0px gray solid;'><a href=write_form.do>파일업로드</a></td>
		</tr>
		<tr align='center'>
			<td style='border:1px gray solid;' align='left'><input type=checkbox name=remove_all onclick="javascript:CheckAll()"

출처: http://galgum.tistory.com/1 [개인주의]></td>
			<td style='border:1px gray solid;'>번호</td>
			<td style='border:1px gray solid;'>제목</td>
			<td style='border:1px gray solid;'>파일명</td>
			<td style='border:1px gray solid;'>작성자</td>
		</tr>
<%
if (totalCount == 0)
	out.println("<tr> <td style=border:1px gray solid; align=center>업로드한 파일이 없습니다</td></tr>");
else {
	for(int i = totalCount - 1;i>=0;--i) {
		out.println("<tr>");
		out.println("<td>" + "<input type=checkbox name=remove_unit value=" + String.valueOf(list.get(i).getNo()).toString()+ ">" + "</td>");
		out.println("<td align='center'>" + String.valueOf(i + 1).toString() + "</td>");
		out.println("<td>" + list.get(i).getTitle() + "</td>");
		out.println("<td>" + list.get(i).getPath() + "</td>");
		out.println("<td align='center'>" + list.get(i).getName() + "</td>");
		out.println("</tr>");
	}
}
%>		
	</table>
</form>
</body>
</html>