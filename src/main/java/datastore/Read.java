package datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Read {
	static Connection conn;
	static Statement statement;
	
	public static void proceed() {
		String query = "SELECT * FROM cafe.orders\r\n";
		ResultSet rs;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "");
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
