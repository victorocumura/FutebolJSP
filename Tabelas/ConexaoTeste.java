package Tabelas;
import java.sql.Connection;

public class ConexaoTeste {

	
	public static void main(String[] args) {
		try {
		Connection conexao = ConnectionFactory.getConnection();
		
		System.out.println("Conectado!");
		
		
		conexao.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

