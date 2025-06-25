package com.sel.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExceptedDataFromDataBase {

	public static void main(String[] args) throws SQLException {
    String ExcpectedProject="Gopu_assign";
    boolean flag = false;
    Driver driverReg=new Driver();
    DriverManager.registerDriver(driverReg);
    Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
    Statement stat = conn.createStatement();
    ResultSet result = stat.executeQuery("Select * from project");
    while(result.next())
    {
    String actualProject = result.getString(4);
    if(ExcpectedProject.equals(actualProject))
    {  
    	flag=true;
    	System.out.println(ExcpectedProject+"is available==Pass");
    }
    }
    if(flag==false)
    {
    	System.out.println(ExcpectedProject+"is not available==Fail");
    }
    
    conn.close();
     
	}

}
