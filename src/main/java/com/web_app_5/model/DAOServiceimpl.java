package com.web_app_5.model;


import java.sql.*;

public class DAOServiceimpl implements DAOService {
	private Connection con;
	private Statement stmt;

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/psa","root","amrit@255");
			stmt=con.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			
			ResultSet res=stmt.executeQuery("select* from login where email='"+email+"' and  pass='"+password+"'");
			return res.next();
	}
			catch(Exception e) {
				e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public void createRegistration(String name, String email, String mobile) {
		try {
			
			stmt.executeUpdate("insert into registration values('"+name+"','"+email+"','"+mobile+"')");
			//stmt.close();
		}catch(Exception e){
			e.printStackTrace();
			
		}

	}

	@Override
	public void deleteRegistration(String email) {
		// TODO Auto-generated method stub
try {
			
			stmt.executeUpdate("delete from registration where email='"+email+"'");
			//stmt.close();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		

	}

	@Override
	public ResultSet listAllReg() {
		try {
			ResultSet rs = stmt.executeQuery("select * from registration");
			if(rs==null)System.out.println("Null hai");
			return rs;
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void updateRegistration(String email, String mobile) {
		// TODO Auto-generated method stub
		try 
		{
			 stmt.executeUpdate("update registration set mobile ='"+mobile+"' where email='"+email+"'");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

}
