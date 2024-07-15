package finances;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {
	public static Connection getConnection() {
	    try {
	    	Properties prop = getProperties();
	        final String url = prop.getProperty("banco.url");
	        final String user = prop.getProperty("banco.user");
	        final String passwd = prop.getProperty("banco.passwd");
	        
	        return DriverManager.getConnection(url, user, passwd);
	    } catch (SQLException | IOException e) {
	        throw new RuntimeException("Erro ao conectar ao banco de dados", e);
	    }
	}
	
	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String path = "/connection.properties";
		prop.load(Factory.class.getResourceAsStream(path));
		return prop;
	}
}
