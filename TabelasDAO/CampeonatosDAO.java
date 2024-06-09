package TabelasDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Tabelas.ConnectionFactory;
import Tabelas.Campeonatos;

public class CampeonatosDAO {

public void inserir(Campeonatos campeonatos) {
		
		String sql = "INSERT INTO Campeonatos("
										+ "nome, "
										+ "data_inicio, "
										+ "data_fim, "
										+ "numero_participantes"
									+ ") "
									+ "VALUES(?, ?, ?, ?)";

		try {
			
			// obtendo conexão
			Connection conexao = ConnectionFactory.getConnection();
			
			// criando PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// configurando parametros
			pstmt.setString(1, campeonatos.getNome());
			pstmt.setString(2, campeonatos.getData_Inicio());
			pstmt.setString(3, campeonatos.getData_Fim());
			pstmt.setInt(4, campeonatos.getNumero_Participantes());

			
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

public void atualizar(Campeonatos campeonatos) {
	// definindo SQL		
	String sql = "UPDATE campeonatos "
					+ "SET "
						+ "nome = ?, "
						+ "data_inicio = ?, "
						+ "data_fim = ?, "
						+ "numero_participantes = ? "
					+ "WHERE codigo = ?";
	
	try {
		
		// obtendo conexão
		Connection conexao = ConnectionFactory.getConnection();
		
		// criando PreparedStatement
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		
		// configurando parametros
		pstmt.setString(1, campeonatos.getNome());
		pstmt.setString(2, campeonatos.getData_Inicio());
		pstmt.setString(3, campeonatos.getData_Fim());
		pstmt.setInt(4, campeonatos.getNumero_Participantes());
		
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
	String sql = "DELETE FROM campeonatos WHERE codigo = ?";
	
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
	
public Campeonatos pesquisarPorCodigo(int codigo) {
	// definindo retorno
	Campeonatos campeonatosRetorno = null;
	
	// definindo SQL
	String sql = "SELECT nome, data_inicio, data_fim, numero_participantes FROM campeonatos WHERE codigo = ?";
	
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
			campeonatosRetorno = new Campeonatos();
			campeonatosRetorno.setCodigo(codigo);
			campeonatosRetorno.setNome(rs.getString(1));
			campeonatosRetorno.setData_Inicio(rs.getString(2));
			campeonatosRetorno.setData_Fim(rs.getString(3));
			campeonatosRetorno.setNumero_Participantes(rs.getInt(4));
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return campeonatosRetorno;
}

public List<Campeonatos> pesquisarTodos() {
	// definindo retorno
	List<Campeonatos> listaDeCampeonatos = new ArrayList<>();
	
	// definindo SQL
	String sql = "SELECT codigo, nome, data_inicio, data_fim, numero_participantes FROM campeonatos";
	
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
			Campeonatos campeonatos = new Campeonatos();
			campeonatos.setCodigo(rs.getInt(1));
			campeonatos.setNome(rs.getString(2));
			campeonatos.setData_Inicio(rs.getString(3));
			campeonatos.setData_Fim(rs.getString(4));
			campeonatos.setNumero_Participantes(rs.getInt(5));
			
			
			listaDeCampeonatos.add(campeonatos);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	return listaDeCampeonatos;
}
	
}

