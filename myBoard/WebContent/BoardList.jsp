<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.esp.board.*" %>
<%@ page import="java.util.*" %>   
<%@ page import="java.net.URLEncoder" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<style>  
table, th, td {  
    border: 1px solid black;  
    border-collapse: collapse;  
}  
th, td {
    padding: 10px;
}
</style> 
<script type="text/javascript">
function SearchKeyword() {
	var form = document.search;
	form.method = post;
	form.action = "search.do";
	form.submit();
}

function StartPage() {
	location.href = "list.do"
}

function CheckAll(){
	var check = false;
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
<h1 align="center">파일목록</h1>
<%
List<Article> list = (List<Article>)request.getAttribute("list");
String id = null;
int totalCount = 3;
if(list != null)
	totalCount = list.size();
%>

<form id="search" name="search" method="post">
	<table>
		<tr>
			<td colspan=3 align="center"><input type="text" name="keyword"></td>
			<td align="center"><input type="button" value="찾기" onclick="javascript:SearchKeyword()"></td>
		</tr>
	</table>
</form>
          
<form id="filelist" name="filelist" method="post">
	<table width='70%' align='center'>		
		<tr>
			<td align="center"><input type="button" value="처음으로" onclick="javascript:StartPage()"></td>
			<td colspan=2 align="center"><input type="button" value="삭 제" onclick="javascript:RemoveUnit()"></td>
			<td align="center"><a href=write_form.do>파일업로드</a></td>
		</tr>
		<tr align='center'>
			<td align="center"><input type=checkbox name=remove_all onclick="javascript:CheckAll()"></td>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
		</tr>
<%
if (totalCount == 0)
	out.println("<tr> <td colspan=4 align=center>업로드한 파일이 없습니다</td></tr>");
else {
	for(int i = totalCount - 1;i>=0;--i) {
		id = String.valueOf(i + 1);
		out.println("<tr>");
		out.println("<td align='center'>" + "<input type=checkbox name=remove_unit value=" + String.valueOf(list.get(i).getNo()).toString()+ ">" + "</td>");
		out.println("<td align='center'>" + id.toString() + "</td>");
		out.println("<td>" + "<a href=detail_form.do?title=" + URLEncoder.encode(list.get(i).getTitle()) + "&id=" + String.valueOf(list.get(i).getNo()).toString() + ">" + list.get(i).getTitle() + "</a>" + "</td>");
		out.println("<td align='center'>" + list.get(i).getName() + "</td>");
		out.println("</tr>");
	}
}
%>		
	</table>
</form>
</body>
</html>