package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.company.model.Customer;

public class CustomerDao 
{
	private static final String dburl ="jdbc:mysql://localhost:3306/project1";
	private static final String dbusername ="root";
	private static final String dbPassword ="Subhasis@123";
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stm = null;
	private static ResultSet rs = null;
	
	private final static String customerListQuery = "select * from customer";
	private final static String insertQuery = "insert into customer(name,email,mobile) values(?,?,?)";
	private final static String editQuery = "select * from customer where id=?";
	private final static String updateQuery = "update customer set name=?,email=?,mobile=? where id =?"; 
	private final static String deleteQuery = "delete from customer where id=?";
	
	
	public static void deleteCustomer(int id) {
	
		try {
			con = getConnectionDef();
			
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void  editCustomer(Customer c) {
		  
		   try {
			   con = getConnectionDef();
			   
			   ps = con.prepareStatement(updateQuery);
			   
			   ps.setString(1,c.getName());
			   ps.setString(2,c.getEmail());
			   ps.setLong(3,c.getMobile());
			   ps.setInt(4,c.getId());
			   
			   ps.executeUpdate();
			   
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	
	
	public static Customer getOneCustomerDetails(int id) {
		   Customer c= null;	
			try {
				con = getConnectionDef();
				ps = con.prepareStatement(editQuery);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				
				rs.next();
				int i = rs.getInt("id");
				String n = rs.getString("name");
				String e = rs.getString("email");
				long m = rs.getLong("mobile");
				 c = new Customer(i,n, e, m);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return c;
		
	}
	
	
	public static void insertCustomer(Customer customer) {
		
		try {
			con = getConnectionDef();
			ps = con.prepareStatement(insertQuery);
			
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setLong(3, customer.getMobile());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
	public static Connection getConnectionDef() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dburl, dbusername, dbPassword);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	
	
	public static ArrayList<Customer> getAllCustomer() {
		ArrayList<Customer> al = new ArrayList<Customer>();
		try {
			con = getConnectionDef();
			stm = con.createStatement();
			rs = stm.executeQuery(customerListQuery);
			
			while(rs.next()) {
				int i = rs.getInt("id");
				String n = rs.getString("name");
				String e = rs.getString("email");
				long m = rs.getLong("mobile");
				
				Customer c = new Customer(i,n, e, m);
				al.add(c);
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return al;
		
		
	}
}
