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
	
	public static void proceed(String id) {
		String s = id;
		int o = Integer.valueOf(s);
		System.out.println("Enter your id\n\n");
		String query = "SELECT * FROM cafe.orders\r\n"
				+ "WHERE id = "+o;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "Trumpet-card-piano");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
		try {
			rs = statement.executeQuery(query);
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt("id")
				+ "\tMeal: " + rs.getString("meal")
				+ "\tDrink: " + rs.getString("drink"));
			}
		} catch (SQLException e) {
			System.out.println("Bad query.");
			e.printStackTrace();
		}
	}

}