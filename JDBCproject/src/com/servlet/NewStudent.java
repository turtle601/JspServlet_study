package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ns")
public class NewStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String s_name = request.getParameter("s_name");
		String s_email = request.getParameter("s_email");
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:turtle601";
		String id = "system";
		String pw = "1234";
		
		try {
			// 1. ����̹� �ε�
			Class.forName(driver);
			// 2. DB - Servlet ���� ���� 
			Connection con = DriverManager.getConnection(url,id,pw);
			// 3. query �ۼ�
			String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
			// 4. PreparedStatement��ü�� ���� DB�� �����͸� �аų� ���� ����
			PreparedStatement statement = con.prepareStatement(sql);
			// ù ��° ����ǥ ���� DB ����
			statement.setString(1, s_name);
			// �� ��° ����ǥ ���� DB ����
			statement.setString(2, s_email);
			
			int rows = statement.executeUpdate();
			
			if (rows > 0) {
				System.out.println("A row has been insert");
			}
			
			con.close();
		
		} catch(SQLException e) {
			System.out.println("OOps,error:");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
