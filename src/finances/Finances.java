package finances;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class Finances {
	public static void main(String[] args) throws SQLException {
		
		Connection connection = Factory.getConnection();

		Statement stmt = connection.createStatement();
		stmt.execute("CREATE DATABASE IF NOT EXISTS finances");

		stmt.execute("USE finances");

		CreateTables.createTables(connection);

		Crud.showMenu();
		
		connection.close();
	}
}
