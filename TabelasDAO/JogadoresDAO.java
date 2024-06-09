package TabelasDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Tabelas.Clubes;
import Tabelas.ConnectionFactory;
import Tabelas.Jogadores;

public class JogadoresDAO {

	public void inserir(Jogadores jogadores) {
		// definindo SQL
		String sql = "INSERT INTO jogadores("
										+ "nome, "
										+ "posicao,"
										+ "pais,"
										+ "clubes_codigo"
									+ ") "
									+ "VALUES(?, ?, ?, ?)";

		try {
			
			// obtendo conexão
			Connection conexao = ConnectionFactory.getConnection();
			
			// criando PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// configurando parametros
			pstmt.setString(1, jogadores.getNome());
			pstmt.setString(2, jogadores.getPosicao());
			pstmt.setString(3, jogadores.getPais());
			pstmt.setInt(4, jogadores.getClubes().getCodigo());
			
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
	
	public void atualizar(Jogadores jogadores) {
		// definindo SQL		
		String sql = "UPDATE jogadores "
						+ "SET "
							+ "nome = ?, "
							+ "posicao = ?, "
							+ "pais = ?, "
							+ "clubes_codigo = ? "
						+ "WHERE codigo = ?";
		
		try {
			
			// obtendo conexão
			Connection conexao = ConnectionFactory.getConnection();
			
			// criando PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// configurando parametros
			pstmt.setString(1, jogadores.getNome());
			pstmt.setString(2, jogadores.getPosicao());
			pstmt.setString(3, jogadores.getPais());
			pstmt.setInt(4, jogadores.getClubes().getCodigo());
			
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
		String sql = "DELETE FROM jogadores WHERE codigo = ?";
		
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
		
	public Jogadores pesquisarPorCodigo(int codigo) {
		// definindo retorno
		Jogadores JogadoresRetorno = null;
		
		// definindo SQL
		String sql = "SELECT nome, posicao, pais, clubes_codigo FROM jogadores WHERE codigo = ?";
		
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
				JogadoresRetorno = new Jogadores();
				JogadoresRetorno.setCodigo(codigo);
				JogadoresRetorno.setNome(rs.getString(1));
				JogadoresRetorno.setPosicao(rs.getString(2));
				JogadoresRetorno.setPais(rs.getString(3));
				ClubesDAO clubesDAO = new ClubesDAO();
				Clubes clubes = clubesDAO.pesquisarPorCodigo(rs.getInt(4));
				JogadoresRetorno.setClubes(clubes);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return JogadoresRetorno;
	}

	public List<Jogadores> pesquisarTodos() {
		// definindo retorno
		List<Jogadores> listaDeJogadores = new ArrayList<>();
		
		// definindo SQL
		String sql = "SELECT codigo, nome, posicao, pais, clubes_codigo FROM jogadores";
		
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
				Jogadores jogadores = new Jogadores();
				jogadores.setCodigo(rs.getInt(1));
				jogadores.setNome(rs.getString(2));
				jogadores.setPosicao(rs.getString(3));
				jogadores.setPais(rs.getString(4));
				ClubesDAO clubesDAO = new ClubesDAO();
				Clubes clubes = clubesDAO.pesquisarPorCodigo(rs.getInt(5));
				jogadores.setClubes(clubes);
				
				listaDeJogadores.add(jogadores);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaDeJogadores;
	}
	
}
