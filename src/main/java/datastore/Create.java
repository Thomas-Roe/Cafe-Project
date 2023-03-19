package datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
	static Connection conn;
	static Statement statement;

	
	public static void proceed() {
		String data;
		String newDB;
		String newTable;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Trumpet-card-piano");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection 1 failed.");
			e.printStackTrace();
		}
		
		newDB = "CREATE DATABASE cafe;";
		try {
			statement.executeUpdate(newDB);
		} catch (SQLException e) {
			System.out.println("Database creation failed.");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "Trumpet-card-piano");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection 2 failed.");
			e.printStackTrace();
		}
		
		newTable = "CREATE TABLE orders " +
				"(id INTEGER not NULL AUTO_INCREMENT, " +
				" Meal VARCHAR(255), " +
				" Drink TEXT, " +
				" Completed BOOL, " +
				" PRIMARY KEY ( id ))";
		try {
			statement.executeUpdate(newTable);
		} catch (SQLException e) {
			System.out.println("Table creation failed.");
			e.printStackTrace();
		}
		try {
			data = "INSERT INTO orders VALUES (1, 'Burger', 'Coke', 0)";
			statement.executeUpdate(data);
			data = "INSERT INTO orders VALUES (2, 'Burger', 'Fanta', 0)";
			statement.executeUpdate(data);
		} catch (SQLException e) {
			System.out.println("Insertion failed.");
			e.printStackTrace();
		}
		
		
	}
}
