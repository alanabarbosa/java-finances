package finances;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class DeleteEntrie {
	public static void deleteEntrie(Connection connection) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);	
		System.out.println("\nDigite o ID da entrada que deseja deletar: ");
		int cod = scanner.nextInt();
		scanner.nextLine();
		
		String selectSQL = "SELECT * FROM entries WHERE id = ?";
		String deleteSQL = "DELETE FROM entries WHERE id = ?";
		
         try (PreparedStatement stmt = connection.prepareStatement(selectSQL)){
        	 
        	 stmt.setInt(1, cod);
             ResultSet result = stmt.executeQuery();
             
             if(result.next()) {
             	try (PreparedStatement deleteStmt = connection.prepareStatement(deleteSQL)) {
             		deleteStmt.setInt(1, cod);
                    
                    int rowsUpdated = deleteStmt.executeUpdate();
                    
                    if (rowsUpdated > 0) {
                        System.out.println("\nEntrada deletada com sucesso!\n");
                    } else {
                        System.out.println("\nFalha ao deletar da entrada.\n");
                    }                    
             	} catch (SQLException e) {
                    e.printStackTrace();
                }
             } else {
             	System.out.println("Registro não encontrado");
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }        
        

        System.out.println("\nEntrada deletada com sucesso!\n");
	}
}
