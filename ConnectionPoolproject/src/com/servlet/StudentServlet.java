package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.StudentDAO;
import com.servlet.dto.StudentDTO;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		StudentDAO studentDAO = new StudentDAO();
		ArrayList<StudentDTO> list= studentDAO.select();
		
		for (int i = 0; i<list.size(); i++) {
			StudentDTO dto = list.get(i);
			int id = dto.getId();
			String name = dto.getName();
			String email = dto.getEmail();			
			
			out.print("id:" + id + "<br>");
			out.print("name:" + name + "<br>");
			out.print("email: " + email + "<br>");
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
