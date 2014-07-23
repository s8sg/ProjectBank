package initconnection;

import java.sql.DriverManager;

import java.sql.*;


public class InitConnection {
  static public Connection getConnection()
  {
	  try{
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  String url="jdbc:oracle:thin:@localhost:1522:XE";
		  Connection conn=(Connection) DriverManager.getConnection(url,"system","root");
		  return conn;  
		  
	  }catch(Exception e){
		  System.out.println("Connection error: "+e.getMessage());
		  return null;
	  }
	
  }
}
