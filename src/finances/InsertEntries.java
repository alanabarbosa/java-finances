package finances;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class InsertEntries {
	public static void insertIntoEntries(Connection connection, 
            String title, String description, Timestamp datetime, double amount) throws SQLException {
        String insertEntries = "INSERT INTO entries ("
        		+ "title, description, datetime, amount) "
        		+ "VALUES (?, ?, ?, ?)";
        
        PreparedStatement stmt = connection.prepareStatement(insertEntries);
        
        stmt.setString(1, title);
        stmt.setString(2, description);
        stmt.setTimestamp(3, datetime);
        stmt.setDouble(4, amount);
        
        stmt.executeUpdate();

        System.out.println("\nEntrada inserida com sucesso!\n");
	}
}
