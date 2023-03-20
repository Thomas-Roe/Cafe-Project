package datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//import java.sql.ResultSet;

public class Update {
	
	static Connection conn;
	static Statement statement;
	
	public static void proceed(Scanner userInput) {
		System.out.println("Enter order id: ");
		String id = userInput.nextLine();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
		try {
			statement.executeUpdate("UPDATE cafe.orders SET completed=1 WHERE id="+id);
		} catch (SQLException e) {
			System.out.println("Insertion failed.");
			e.printStackTrace();
		}
	}
}