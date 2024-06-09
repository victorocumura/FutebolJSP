package TabelasDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Tabelas.Clubes;
import Tabelas.ConnectionFactory;

public class ClubesDAO {

	public void inserir(Clubes clubes) {

		String sql = "INSERT INTO Clubes("
				+ "nome, "
				+ "mascote, "
				+ "numero_titulos "
			+ ") "
			+ "VALUES(?, ?, ?)";

try {

// obtendo conexão
Connection conexao = ConnectionFactory.getConnection();

// criando PreparedStatement
PreparedStatement pstmt = conexao.prepareStatement(sql);

// configurando parametros
pstmt.setString(1, clubes.getNome());
pstmt.setString(2, clubes.getMascote());
pstmt.setInt(3, clubes.getNumero_Titulos());


// executar PreparedStatement
pstmt.execute();

// fechando PreparedStatement
pstmt.close();

// fechando conexão
conexao.close();

} catch (Exception e) {
e.printStackTrace();
}	
}
	
	public void atualizar(Clubes clubes) {
		// definindo SQL		
		String sql = "UPDATE clubes "
						+ "SET "
							+ "nome = ?, "
							+ "mascote = ?, "
							+ "numero_titulos = ? "
						+ "WHERE codigo = ?";
		
		try {
			
			// obtendo conexão
			Connection conexao = ConnectionFactory.getConnection();
			
			// criando PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// configurando parametros
			pstmt.setString(1, clubes.getNome());
			pstmt.setString(2, clubes.getMascote());
			pstmt.setInt(3, clubes.getNumero_Titulos());
			
			// executando PreparedStatement
			pstmt.execute();
			
			// fechando PreparedStatement
			pstmt.close();
			
			// fechando conexão
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int codigo) {
		// definindo SQL		
		String sql = "DELETE FROM clubes WHERE codigo = ?";
		
		try {
			
			// obtendo conexão
			Connection conexao = ConnectionFactory.getConnection();
			
			// criando PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// configurando parametros
			pstmt.setInt(1, codigo);
			
			// executando PreparedStatement
			pstmt.execute();
			
			// fechando PreparedStatement
			pstmt.close();
			
			// fechando conexão
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Clubes pesquisarPorCodigo(int codigo) {
		// definindo retorno
		Clubes clubesRetorno = null;
		
		// definindo SQL
		String sql = "SELECT nome, mascote, numero_titulos FROM clubes WHERE codigo = ?";
		
		try {
			
			// obtendo conexão
			Connection conexao = ConnectionFactory.getConnection();
			
			// criando PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// configurando parametros
			pstmt.setInt(1, codigo);
			
			// executando PreparedStatement e recebendo retorno
			ResultSet rs = pstmt.executeQuery();
			
			// tratando retorno
			if(rs.next()) {
				clubesRetorno = new Clubes();
				clubesRetorno.setCodigo(codigo);
				clubesRetorno.setNome(rs.getString(1));
				clubesRetorno.setMascote(rs.getString(2));
				clubesRetorno.setNumero_Titulos(rs.getInt(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return clubesRetorno;
	}
	
	public List<Clubes> pesquisarTodos() {
		// definindo retorno
		List<Clubes> listaDeClubes = new ArrayList<>();
		
		// definindo SQL
		String sql = "SELECT codigo, nome, mascote, numero_titulos FROM clubes";
		
		try {
			
			// obtendo conexão
			Connection conexao = ConnectionFactory.getConnection();
			
			// criando PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// configurando parametros (não há parametros, nesse caso)
			
			// executando PreparedStatement e recebendo retorno
			ResultSet rs = pstmt.executeQuery();
			
			// tratando retorno
			while(rs.next()) {
				Clubes clubes = new Clubes();
				clubes.setCodigo(rs.getInt(1));
				clubes.setNome(rs.getString(2));
				clubes.setMascote(rs.getString(3));
				clubes.setNumero_Titulos(rs.getInt(4));
				
				listaDeClubes.add(clubes);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaDeClubes;
	}
	
}
