package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lc")
public class LoginCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String ID = request.getParameter("id");
		String PW = request.getParameter("pw");
		
		out.print("ID");
		out.print("PW");
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		// 클라이언트에서 받은 쿠키 중 해당하는 쿠키가 있는지 찾는다.
		for (Cookie c : cookies) {
			System.out.println("c.getName():" + c.getName());
			System.out.println("c.getValue():" + c.getValue());
			// 해당 쿠키가 있을 경우 cookie 객체에 삽입
			if(c.getName().equals("memberId")) {
				cookie = c;
			}
		}
		
		
		if(cookie == null) {
			System.out.println("cookie is null");
			 //해당 쿠키가 없을 경우 새로운 쿠키를 생성(cookie 객체)
			cookie = new Cookie("memberId",ID);
		}
		
		//클라이언트에 cookie를 추가 시킨다. 
		response.addCookie(cookie);
		//쿠키 만료시간 = 1시간
		cookie.setMaxAge(60*60);
		
		response.sendRedirect("loginOK.jsp");;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
