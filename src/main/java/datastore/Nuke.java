package datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.ResultSet;
import java.util.Scanner;

public class Nuke {
	static Connection conn;
	static Statement statement;

	public static void proceed() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
		try {
			statement.executeUpdate("DELETE FROM cafe.orders");
		} catch (SQLException e) {
			System.out.println("Deletion failed.");
			e.printStackTrace();
		}
	}
}
