package finances;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class UpdateEntrie {
	public static void updateEntrie(Connection connection, Timestamp newDatetime) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);	
		System.out.println("Digite o ID da entrada que deseja atualizar: ");
		int cod = scanner.nextInt();
		scanner.nextLine();

		System.out.println("\nQual o novo nome da entrada?");
		String name = scanner.nextLine();
		
		System.out.println("Qual a nova descrição da entrada?");
		String description = scanner.nextLine();
		
		System.out.println("Qual o novo valor da entrada?");
		double amount = Double.parseDouble(scanner.nextLine());
		
		String sql = "SELECT * FROM entries WHERE id = ?";
		String updateSQL = "UPDATE entries SET title = ?, "
				+ "description = ?, datetime = ?, amount = ? WHERE id = ?";
		
         try (PreparedStatement stmt = connection.prepareStatement(sql)){
        	 
        	 stmt.setInt(1, cod);
             ResultSet result = stmt.executeQuery();
             
             if(result.next()) {
             	try (PreparedStatement updateStmt = connection.prepareStatement(updateSQL)) {
                    updateStmt.setString(1, name);
                    updateStmt.setString(2, description);
                    updateStmt.setTimestamp(3, newDatetime);
                    updateStmt.setDouble(4, amount);
                    updateStmt.setInt(5, cod);
                    
                    int rowsUpdated = updateStmt.executeUpdate();
                    
                    if (rowsUpdated > 0) {
                        System.out.println("\nEntrada atualizada com sucesso!\n");
                    } else {
                        System.out.println("\nFalha na atualização da entrada.\n");
                    }                    
             	} catch (SQLException e) {
                    e.printStackTrace();
                }
             } else {
             	System.out.println("Registro não encontrado");
             }
         }            
        

        System.out.println("\nEntrada atualizada com sucesso!\n");
	}
}
