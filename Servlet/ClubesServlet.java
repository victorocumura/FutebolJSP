package Servlet;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TabelasDAO.ClubesDAO;
import Tabelas.Clubes;


@WebServlet("/clubesServlet")
public class ClubesServlet extends HttpServlet {

	public void service(HttpServletRequest request,
			HttpServletResponse response) {

try {

// recebendo parametros do formulario
String codigo = request.getParameter("codigo");
String nome = request.getParameter("nome");
String mascote =  request.getParameter("mascote");
String numero_titulos =  request.getParameter("numero_titulos");

// montando objeto com os parametros recebidos
Clubes clubes = new Clubes();
clubes.setCodigo(Integer.parseInt(codigo));
clubes.setNome(nome);
clubes.setMascote(mascote);
clubes.setNumero_Titulos(Integer.parseInt(numero_titulos));

// utilizando DAO para inserir objeto
ClubesDAO clubesDAO = new ClubesDAO();
clubesDAO.inserir(clubes);

//configurando encaminhamento
RequestDispatcher rq = request.getRequestDispatcher("clubes.jsp");
//executando encaminhamento
rq.forward(request, response);

} catch (Exception e) {
e.printStackTrace();
}

}
}
