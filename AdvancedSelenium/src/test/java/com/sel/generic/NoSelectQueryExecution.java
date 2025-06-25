package com.sel.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NoSelectQueryExecution {

	public static void main(String[] args) throws SQLException {
      Driver driverReg=new Driver();
      DriverManager.registerDriver(driverReg);
     Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
      System.out.println("Done++++");
     Statement stat = conn.createStatement();
     int resultSet = stat.executeUpdate("insert into project values('TG_1234_11','minigopu','2025-05-12','Gopu_assign','created','40');");
	System.out.println(resultSet);
	conn.close();
	}

}
