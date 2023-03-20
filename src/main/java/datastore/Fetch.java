package datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Fetch {
	static Connection conn;
	static Statement statement;
	
	public static void proceed(Scanner userInput) {
		System.out.println("Enter your id\n\n");
		String id = userInput.nextLine();
		String query = "SELECT * FROM cafe.orders\r\n"
				+ "WHERE id = "+id;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
		try {
			rs = statement.executeQuery(query);
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt("id")
				+ "\tMeal: " + rs.getString("meal"));
			}
		} catch (SQLException e) {
			System.out.println("Bad query.");
			e.printStackTrace();
		}
	}

}