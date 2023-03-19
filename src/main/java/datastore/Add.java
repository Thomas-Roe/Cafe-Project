package datastore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Add {
	static Connection conn;
	static Statement statement;

	
	public static void proceed(Scanner userInput) {
		String data;
		System.out.println("Enter meal name: ");
		String meal = userInput.nextLine();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Trumpet-card-piano");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection 1 failed.");
			e.printStackTrace();
		}
		try {
			data = "INSERT INTO cafe.orders (Meal, Completed) VALUES ('" + meal + "', 0)";
			statement.executeUpdate(data);
		} catch (SQLException e) {
			System.out.println("Insertion failed.");
			e.printStackTrace();
		}
	}
}