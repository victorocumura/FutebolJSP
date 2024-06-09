package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tabelas.Jogos;
import Tabelas.Campeonatos;
import TabelasDAO.JogosDAO;
import TabelasDAO.CampeonatosDAO;


@WebServlet("/jogosServlet")
public class JogosServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request,
						HttpServletResponse response) {
		
		try {
		
			// recebendo parâmetros
			String codigo = request.getParameter("codigo");
			String data_jogo = request.getParameter("data_jogo");
			String hora_jogo = request.getParameter("hora_jogo");
			String mandante = request.getParameter("mandante");
			String visitante = request.getParameter("visitante");
			String gols_mandante = request.getParameter("gols_mandante");
			String gols_visitante = request.getParameter("gols_visitante");
			String local_jogo = request.getParameter("local_jogo");
			String campeonatos_codigo = request.getParameter("campeonatos_codigo");
			
			// montando objeto com parâmetros recebidos
			Jogos jogos = new Jogos();
			jogos.setCodigo(Integer.parseInt(codigo));
			jogos.setData_Jogo(data_jogo);
			jogos.setHora_Jogo(hora_jogo);
			jogos.setMandante(mandante);
			jogos.setVisitante(visitante);
			jogos.setGols_Mandante(Integer.parseInt(gols_mandante));
			jogos.setGols_Visitante(Integer.parseInt(gols_visitante));
			jogos.setLocal_Jogo(local_jogo);
			CampeonatosDAO campeonatosDAO = new CampeonatosDAO();
			Campeonatos campeonatos = 
					campeonatosDAO.pesquisarPorCodigo(Integer.parseInt(campeonatos_codigo));
			jogos.setCampeonatos(campeonatos);
			
			// utilizando DAO para inserir objeto
			JogosDAO jogosDAO = new JogosDAO();
			jogosDAO.inserir(jogos);
			
			// configurando encaminhamento
			RequestDispatcher rq = request.getRequestDispatcher("jogos.jsp");
			// executando encaminhamento
			rq.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
