package com.servlet.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.servlet.dto.StudentDTO;

public class StudentDAO {
	
	DataSource dataSource;
	
	
	public StudentDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle19c");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<StudentDTO> select(){
		
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT * FROM students";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				
				int s_id = res.getInt("ID");
				String s_name = res.getString("NAME");
				String s_email = res.getString("EMAIL");
				
				StudentDTO studentDTO = new StudentDTO(s_id,s_name,s_email);
				list.add(studentDTO);
				
			}
			
								
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
}
