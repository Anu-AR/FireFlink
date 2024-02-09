package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCTest {

	public static void main(String[] args) throws Throwable
	{
		//Step - 1 Register the Driver class
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Step -2 create connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
				
		//Step-3 Create Statement
		 Statement statement = connection.createStatement();
		 String query = "select * from projects;";
		
		 //Step-4 Execute Query
		
		 ResultSet resultSet = statement.executeQuery(query);
		 while(resultSet.next())
		 {
			 System.out.println(resultSet.getString(1));
		 }
		 System.out.println(resultSet);
		 //Step-5 close connection
		 connection.close();
		 
				
				
	}

}
