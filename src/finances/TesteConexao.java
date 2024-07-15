package finances;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
	
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/";
		final String user = "root";
		final String passwd = "MyP@ssw0rd123!";
		
		Connection connection = DriverManager
					.getConnection(url, user, passwd);
		
		System.out.println("Conexão efetuada");
		
		connection.close();
	}
	
}
