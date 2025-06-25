package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	 Connection conn=null;
	 
	 public void getDBconnecction(String url ,String username,String password) throws SQLException
	 {
		 try {
		 Driver driver=new Driver();
		 DriverManager.registerDriver(driver);
		 conn = DriverManager.getConnection(url, username, password);
		 }
		 catch(Exception e)
		 {
			 
		 } 
	 }
	 
 public void getDBconnecction() throws SQLException
 {
	 try {
	 Driver driver=new Driver();
	 DriverManager.registerDriver(driver);
	 conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
	 }
	 catch(Exception e)
	 {
		 
	 } 
 }
 public void closeDbconnectio()
 {
	 try {

		 conn.close();
		
	} catch (Exception e) {
	
	}
	 
 }
 public ResultSet executeSelectQuery(String query) throws SQLException
 {
	 ResultSet resultSet=null;
	 try {
		 Statement stat = conn.createStatement();
		 resultSet = stat.executeQuery(query);
		
	} catch (Exception e) {
	
	}
	 return resultSet;

 }
 public int executeUpdateQuery(String Query) throws SQLException
 {
	 int resultSet=0;
	 try {
		 Statement stat = conn.createStatement();
		 resultSet = stat.executeUpdate(Query);
		
	} catch (Exception e) {
		
	}
	
	 return resultSet;
	 
	 
 }
}
