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
			// 1. 드라이버 로딩
			Class.forName(driver);
			// 2. DB - Servlet 서로 연결 
			Connection con = DriverManager.getConnection(url,id,pw);
			// 3. query 작성
			String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
			// 4. PreparedStatement객체를 통해 DB의 데이터를 읽거나 쓰기 가능
			PreparedStatement statement = con.prepareStatement(sql);
			// 첫 번째 물음표 값에 DB 삽입
			statement.setString(1, s_name);
			// 두 번째 물음표 값에 DB 삽입
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
