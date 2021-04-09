<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 기존에 세션이 있었는지 없었는지 여부 판단 -->
	<%
		if(session.getAttribute("memberID")!=null){
			
			response.sendRedirect("loginOK.jsp");
		}
	%>
	<form action = "lc" method = "post">
		ID: <input type = "text" name = "id"><br>
		PW: <input type = "text" name = "pw"><br>
		<input type = "submit" value = "press">
	
	</form>
</body>
</html>