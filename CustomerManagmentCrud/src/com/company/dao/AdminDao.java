package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao {
   
	private static final String dburl ="jdbc:mysql://localhost:3306/project1";
	private static final String dbusername ="root";
	private static final String dbPassword ="Subhasis@123";
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private final static String dbValidate = "select * from store_admin where name=? and password=?";


	public static boolean validateAdmin(String user, String pwd) 
	{
		boolean b = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dburl, dbusername, dbPassword);
			
			ps = con.prepareStatement(dbValidate);
			
			ps.setString(1, user);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			
			b = rs.next();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
}
