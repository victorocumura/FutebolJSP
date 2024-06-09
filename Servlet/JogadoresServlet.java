package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tabelas.Clubes;
import Tabelas.Jogadores;
import TabelasDAO.ClubesDAO;
import TabelasDAO.JogadoresDAO;


@WebServlet("/jogadoresServlet")
public class JogadoresServlet extends HttpServlet {
		

	protected void doPost(HttpServletRequest request,
						HttpServletResponse response) {
		
		try {
		
			// recebendo parâmetros
			String codigo = request.getParameter("codigo");
			String nome = request.getParameter("nome");
			String posicao = request.getParameter("posicao");
			String pais = request.getParameter("pais");
			String clubes_codigo = request.getParameter("clubes_codigo");
			
			// montando objeto com parâmetros recebidos
			Jogadores jogadores = new Jogadores();
			jogadores.setCodigo(Integer.parseInt(codigo));
			jogadores.setNome(nome);
			jogadores.setPosicao(posicao);
			jogadores.setPais(pais);
			ClubesDAO clubesDAO = new ClubesDAO();
			Clubes clubes = 
					clubesDAO.pesquisarPorCodigo(Integer.parseInt(clubes_codigo));
			jogadores.setClubes(clubes);
			
			// utilizando DAO para inserir objeto
			JogadoresDAO jogadoresDAO = new JogadoresDAO();
			jogadoresDAO.inserir(jogadores);
			
			// configurando encaminhamento
			RequestDispatcher rq = request.getRequestDispatcher("jogadores.jsp");
			// executando encaminhamento
			rq.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
