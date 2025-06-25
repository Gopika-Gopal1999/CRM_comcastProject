package com.sel.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleJdbcTest {

	public static void main(String[] args) throws SQLException {
		  Connection conn=null;
		//step:1 load/register the database driver
		Driver diverRef=new Driver();
      DriverManager.registerDriver(diverRef);
     //step:2 Connect to database
     conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
      System.out.println("========Done=======");
      //Step:3 Create sql statements
      Statement stat = conn.createStatement();
      try {
      //Step:4 Execute select query and get result
      ResultSet resultset = stat.executeQuery("select * from project");
      while(resultset.next())
      {
    	  System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
      }
      }
      catch(Exception e){
    	  System.out.println("handle Expection");
    	  
      }finally {
      //Step:5 close the connection
      conn.close();
      
      }
	} 

}
