<%@ page import="TabelasDAO.JogosDAO" %>
<%@ page import="Tabelas.Jogos" %>
<%@ page import="TabelasDAO.CampeonatosDAO" %>
<%@ page import="Tabelas.Campeonatos" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		<title>Cadastro de Jogos</title>
	</head>
	<body>
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="/AgendaJSP">FutebolJSP</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="/FutebolJSP">Home</a>
		        </li>
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Cadastros
		          </a>
		          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		            <li><a class="dropdown-item" href="campeonatos.jsp">Campeonatos</a></li>
		            <li><a class="dropdown-item" href="clubes.jsp">Clubes</a></li>
		            <li><a class="dropdown-item" href="jogadores.jsp">Jogadores</a></li>
		            <li><a class="dropdown-item" href="jogos.jsp">Jogos</a></li>
		          </ul>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
	
		<div class="container">
	
			<h1>Cadastro de Jogos</h1>
			
			<form method="post" action="jogosServlet">
				<fieldset>
					<label for="codigo" class='form-label'>Código:</label>
					<input type="number" name="codigo" class='form-control'/>
				</fieldset>
				<fieldset>
					<label for="data_jogo" class='form-label'>Data Jogo:</label>
					<input type="text" name="data_jogo" class='form-control'/>
				</fieldset>
				<fieldset>
					<label for="hora_jogo" class='form-label'>Hora Jogo:</label>
					<input type="text" name="hora_jogo" class='form-control'/>
				</fieldset>
				<fieldset>
					<label for="mandante" class='form-label'>Mandante:</label>
					<input type="text" name="mandante" class='form-control'/>
				</fieldset>
				<fieldset>
					<label for="visitante" class='form-label'>Visitante:</label>
					<input type="text" name="visitante" class='form-control'/>
				</fieldset>
				<fieldset>
					<label for="gols_mandante" class='form-label'>Gols Mandante:</label>
					<input type="number" name="gols_mandante" class='form-control'/>
				</fieldset>
				<fieldset>
					<label for="gols_visitante" class='form-label'>Gols Visitante:</label>
					<input type="number" name="gols_visitante" class='form-control'/>
				</fieldset>
				<fieldset>
					<label for="local_jogo" class='form-label'>Local Jogo:</label>
					<input type="text" name="local_jogo" class='form-control'/>
				</fieldset>
				<fieldset>
					<label for="campeonatos_codigo" class="form-label">Campeonato:</label>
					<select name="campeonatos_codigo" class="form-control">
						<%
							CampeonatosDAO campeonatosDAO = new CampeonatosDAO();
							List<Campeonatos> campeonato = campeonatosDAO.pesquisarTodos();
							
							for(Campeonatos campeonatos : campeonato) {
						%>
							<option value="<%= campeonatos.getCodigo() %>">
								<%= campeonatos.getNome() %>
							</option>
						<% } %>
					</select>
				</fieldset>
				
				<br/>
				
				<p>
					<button type="submit" class='btn btn-primary'>Gravar</button>
				</p>
			</form>
			
			<hr/>
			
			<h2>Listagem de Jogadores</h2>
			
			<table class="table table-hover">
				<thead>
					<tr>
						<td>Código</td>
						<td>Data Jogo</td>
						<td>Hora Jogo</td>
						<td>Mandante</td>
						<td>Visitante</td>
						<td>Mandante</td>
						<td>Gols Mandante</td>
						<td>Gols Visitante</td>
						<td>Local Jogo</td>
						<td>Campeonato</td>
					</tr>
				</thead>
				<tbody>
					<%
						JogosDAO jogosDAO = new JogosDAO();
						List<Jogos> jogo = jogosDAO.pesquisarTodos();
						
						for(Jogos jogos : jogo) {
					%>
						<tr>
							<td><%= jogos.getCodigo() %></td>
							<td><%= jogos.getData_Jogo() %></td>
							<td><%= jogos.getHora_Jogo() %></td>
							<td><%= jogos.getMandante() %></td>
							<td><%= jogos.getVisitante() %></td>
							<td><%= jogos.getGols_Mandante() %></td>
							<td><%= jogos.getGols_Visitante() %></td>
							<td><%= jogos.getLocal_Jogo() %></td>
							<td><%= jogos.getCampeonatos().getNome() %></td>
						</tr>
					<% } %>
				</tbody>
			</table>
			
			<footer>
				<hr/>
				Todos os direitos reservados.
			</footer>
		</div>
	</body>
</html>