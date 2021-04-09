<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인 페이지에 쿠키가 잇는지 없는지 확인 -->
	<%
		Cookie[] cookies = request.getCookies();
		System.out.println(cookies);
		
		 if(cookies != null){
			 for(Cookie c : cookies){
				 if(c.getName().equals("memberId")){
					 response.sendRedirect("loginOK.jsp");
				 }
				 
			 }
			 
		 }
	%>
	<form action = "lc" method = "post">
		ID: <input type = "text" name = "id">
		PW: <input type = "text" name = "pw">
		<input type = "submit" value = "press">
	</form>
</body>
</html>