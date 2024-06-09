package TabelasDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Tabelas.Campeonatos;
import Tabelas.ConnectionFactory;
import Tabelas.Jogos;

public class JogosDAO {

	public void inserir(Jogos jogos) {
		// definindo SQL
		String sql = "INSERT INTO jogos("
										+ "data_jogo, "
										+ "hora_jogo, "
										+ "mandante, "
										+ "visitante, "
										+ "gols_mandante, "
										+ "gols_visitante, "
										+ "local_jogo, "
										+ "campeonatos_codigo "
									+ ") "
									+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			
			// obtendo conexão
			Connection conexao = ConnectionFactory.getConnection();
			
			// criando PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// configurando parametros
			pstmt.setString(1, jogos.getData_Jogo());
			pstmt.setString(2, jogos.getHora_Jogo());
			pstmt.setString(3, jogos.getMandante());
			pstmt.setString(4, jogos.getVisitante());
			pstmt.setInt(5, jogos.getGols_Mandante());
			pstmt.setInt(6, jogos.getGols_Visitante());
			pstmt.setString(7, jogos.getLocal_Jogo());
			pstmt.setInt(8, jogos.getCampeonatos().getCodigo());
			
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
	
	public void atualizar(Jogos jogos) {
		// definindo SQL		
		String sql = "UPDATE jogos "
						+ "SET "
							+ "data_jogo = ?, "
							+ "hora_jogo = ?, "
							+ "mandante = ?, "
							+ "visitante = ?, "
							+ "gols_mandante = ?, "
							+ "gols_visitante = ?, "
							+ "local_jogo = ?, "
							+ "campeonatos_codigo = ? "
						+ "WHERE codigo = ?";
		
		try {
			
			// obtendo conexão
			Connection conexao = ConnectionFactory.getConnection();
			
			// criando PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// configurando parametros
			pstmt.setString(1, jogos.getData_Jogo());
			pstmt.setString(2, jogos.getHora_Jogo());
			pstmt.setString(3, jogos.getMandante());
			pstmt.setString(4, jogos.getVisitante());
			pstmt.setInt(5, jogos.getGols_Mandante());
			pstmt.setInt(6, jogos.getGols_Visitante());
			pstmt.setString(7, jogos.getLocal_Jogo());
			pstmt.setInt(8, jogos.getCampeonatos().getCodigo());
			
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
		String sql = "DELETE FROM jogos WHERE codigo = ?";
		
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
		
	public Jogos pesquisarPorCodigo(int codigo) {
		// definindo retorno
		Jogos JogosRetorno = null;
		
		// definindo SQL
		String sql = "SELECT data_jogo, hora_jogo, mandante, visitante, gols_mandante, gols_visitante, local_jogo, campeonatos_codigo FROM jogos WHERE codigo = ?";
		
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
				JogosRetorno = new Jogos();
				JogosRetorno.setCodigo(codigo);
				JogosRetorno.setData_Jogo(rs.getString(1));
				JogosRetorno.setHora_Jogo(rs.getString(2));
				JogosRetorno.setMandante(rs.getString(3));
				JogosRetorno.setVisitante(rs.getString(4));
				JogosRetorno.setGols_Mandante(rs.getInt(5));
				JogosRetorno.setGols_Visitante(rs.getInt(6));
				JogosRetorno.setLocal_Jogo(rs.getString(7));
				CampeonatosDAO campeonatosDAO = new CampeonatosDAO();
				Campeonatos campeonatos = campeonatosDAO.pesquisarPorCodigo(rs.getInt(8));
				JogosRetorno.setCampeonatos(campeonatos);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return JogosRetorno;
	}

	public List<Jogos> pesquisarTodos() {
		// definindo retorno
		List<Jogos> listaDeJogos = new ArrayList<>();
		
		// definindo SQL
		String sql = "SELECT codigo, data_jogo, hora_jogo, mandante, visitante, gols_mandante, gols_visitante, local_jogo, campeonatos_codigo FROM jogos";
		
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
				Jogos jogos = new Jogos();
				jogos.setCodigo(rs.getInt(1));
				jogos.setData_Jogo(rs.getString(2));
				jogos.setHora_Jogo(rs.getString(3));
				jogos.setMandante(rs.getString(4));
				jogos.setVisitante(rs.getString(5));
				jogos.setGols_Mandante(rs.getInt(6));
				jogos.setGols_Visitante(rs.getInt(7));
				jogos.setLocal_Jogo(rs.getString(8));
				CampeonatosDAO campeonatosDAO = new CampeonatosDAO();
				Campeonatos campeonatos = campeonatosDAO.pesquisarPorCodigo(rs.getInt(9));
				jogos.setCampeonatos(campeonatos);
				
				listaDeJogos.add(jogos);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaDeJogos;
	}
	
}
