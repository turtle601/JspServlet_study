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
		// Ŭ���̾�Ʈ���� ���� ��Ű �� �ش��ϴ� ��Ű�� �ִ��� ã�´�.
		for (Cookie c : cookies) {
			System.out.println("c.getName():" + c.getName());
			System.out.println("c.getValue():" + c.getValue());
			// �ش� ��Ű�� ���� ��� cookie ��ü�� ����
			if(c.getName().equals("memberId")) {
				cookie = c;
			}
		}
		
		
		if(cookie == null) {
			System.out.println("cookie is null");
			 //�ش� ��Ű�� ���� ��� ���ο� ��Ű�� ����(cookie ��ü)
			cookie = new Cookie("memberId",ID);
		}
		
		//Ŭ���̾�Ʈ�� cookie�� �߰� ��Ų��. 
		response.addCookie(cookie);
		//��Ű ����ð� = 1�ð�
		cookie.setMaxAge(60*60);
		
		response.sendRedirect("loginOK.jsp");;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
