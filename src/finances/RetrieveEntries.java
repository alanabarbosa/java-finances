package finances;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveEntries {
	public static void retrieveAllEntries(Connection connection) throws SQLException {
		String query = "SELECT * FROM entries";
		
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			ResultSet result = stmt.executeQuery();		
			
			double totalAmount = 0.0;
            int count = 0;
			
			System.out.println("\nID| Titulo | Descrição | Data | Valor");	
			
			while (result.next()) {
				int id = result.getInt("id");
				String title = result.getString("title");
				String description = result.getString("description");
				Timestamp datetime = result.getTimestamp("datetime");
				double amount = result.getDouble("amount");
				
                totalAmount += amount;
                count++;
				
				System.out.println(id + " | " + title + " | " + description + " | " 
				+ datetime + " | " + amount);
				
			}
			
            if (count > 0) {
                System.out.println("\nValor total das entradas: " + totalAmount);
            } else {
                System.out.println("\nNão há entradas cadastradas\n");
            }
		}
	}
}
