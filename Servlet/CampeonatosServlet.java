package Servlet;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TabelasDAO.CampeonatosDAO;
import Tabelas.Campeonatos;


@WebServlet("/campeonatosServlet")
public class CampeonatosServlet extends HttpServlet {


	public void service(HttpServletRequest request,
			HttpServletResponse response) {

try {

// recebendo parametros do formulario
String codigo = request.getParameter("codigo");
String nome = request.getParameter("nome");
String data_inicio =  request.getParameter("data_inicio");
String data_fim =  request.getParameter("data_fim");
String numero_participantes =  request.getParameter("numero_participantes");

// montando objeto com os parametros recebidos
Campeonatos campeonatos = new Campeonatos();
campeonatos.setCodigo(Integer.parseInt(codigo));
campeonatos.setNome(nome);
campeonatos.setData_Inicio(data_inicio);
campeonatos.setData_Fim(data_fim);
campeonatos.setNumero_Participantes(Integer.parseInt(numero_participantes));

// utilizando DAO para inserir objeto
CampeonatosDAO campeonatosDAO = new CampeonatosDAO();
campeonatosDAO.inserir(campeonatos);

//configurando encaminhamento
RequestDispatcher rq = request.getRequestDispatcher("campeonatos.jsp");
// executando encaminhamento
rq.forward(request, response);

} catch (Exception e) {
e.printStackTrace();
}

}
}
