package studentapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDBConnection{
	public static void main(String[] args) {
		
		String insert = "insert into student_management.students values(108,'sujatha',20,'A','Female')";
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=12345");
			System.out.println("connection Established");
			Statement statement = connection.createStatement();
			System.out.println("platform created");
			int result = statement.executeUpdate(insert);
			System.out.println(result);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}

