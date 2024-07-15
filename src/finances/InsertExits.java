package finances;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class InsertExits {
	public static void insertIntoExits(Connection connection, 
            String title, String description, Timestamp datetime, double amount) throws SQLException {
        String insertExits = "INSERT INTO exits ("
        		+ "title, description, datetime, amount) "
        		+ "VALUES (?, ?, ?, ?)";
        
        PreparedStatement stmt = connection.prepareStatement(insertExits);
        
        stmt.setString(1, title);
        stmt.setString(2, description);
        stmt.setTimestamp(3, datetime);
        stmt.setDouble(4, amount);
        
        stmt.executeUpdate();

        System.out.println("\nSaída inserida com sucesso!\n");
	}
}
