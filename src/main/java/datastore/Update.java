package datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.ResultSet;

public class Update {
	static Connection conn;
	static Statement statement;
	
	public static void proceed() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collection", "root", "Trumpet-card-piano");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
		try {
			statement.executeUpdate("UPDATE games SET name='Sword Art Online: AL' WHERE id=1");
			statement.executeUpdate("UPDATE games SET completed=1 WHERE id=4");
			statement.executeUpdate("INSERT INTO games VALUES (8, 'Nier Replicant', 'Action JRPG', 'Steam', 1)");
		} catch (SQLException e) {
			System.out.println("Insertion failed.");
			e.printStackTrace();
		}
	}
}
