package Tabelas;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	
	private static final String URL = "jdbc:mysql://localhost:3306/futebol";
	private static final String USUARIO = "usuario";
	private static final String SENHA = "Admin123";
	
	public static Connection getConnection() {
		Connection connection = null;
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch(Exception e) {
		e.printStackTrace();
	}
		return connection;
}
}
