package finances;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    public static void createTables(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        
       String createEntriesTable = "CREATE TABLE IF NOT EXISTS entries ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "title VARCHAR(80),"
                + "description VARCHAR(255),"
                + "datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "amount DECIMAL(10,2)"
                + ")";
        stmt.execute(createEntriesTable);

        String createExitsTable = "CREATE TABLE IF NOT EXISTS exits ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "title VARCHAR(80),"
                + "description VARCHAR(255),"
                + "datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "amount DECIMAL(10,2)"
                + ")";
        stmt.execute(createExitsTable);

        System.out.println("\nTabelas criadas com sucesso!\n");
    }
}
