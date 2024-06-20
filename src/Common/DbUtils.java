package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {
	private static Connection connection;
	private static Statement statement;

	static {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "sneha@123");
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet executeSelectQuery(String query) throws SQLException { // Select query
		ResultSet result = statement.executeQuery(query);
		return result;
	}

	public static void executeQuery(String query) throws SQLException { // Insert, Update, Delete, Create, Drop, //
																		// truncate
		statement.execute(query);
	}

}
