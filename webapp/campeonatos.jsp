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
		<title>Cadastro de Campeonatos</title>
	</head>
	<body>
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="/FutebolJSP">Futebol</a>
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
	
			<h1>Cadastro de Campeonatos</h1>
			
			<form method="post" action="campeonatosServlet">
				<fieldset>
					<label for="codigo" class='form-label'>Código:</label>
					<input type="number" name="codigo" class='form-control'/>
				</fieldset>
				<fieldset>
					<label for="nome" class='form-label'>Nome:</label>
					<input type="text" name="nome" class='form-control'/>
				</fieldset>
				<fieldset>
					<label for="data_inicio" class='form-label'>Data de Inicio:</label>
					<input type="text" name="data_inicio" class='form-control'/>
				</fieldset>
				<fieldset>
					<label for="data_fim" class='form-label'>Data de Fim:</label>
					<input type="text" name="data_fim" class='form-control'/>
				</fieldset>
				<fieldset>
					<label for="numero_participantes" class='form-label'>Numero de Participantes:</label>
					<input type="number" name="numero_participantes" class='form-control'/>
				</fieldset>
				
				<br/>
				
				<p>
					<button type="submit" class='btn btn-primary'>Gravar</button>
				</p>
			</form>
			
			<hr/>
			
			<h2>Listagem de Campeonatos</h2>
			
			<table class="table table-hover">
				<thead>
					<tr>
						<td>Código</td>
						<td>Nome</td>
						<td>Data de Inicio</td>
						<td>Data de Fim</td>
						<td>Numero de Participantes</td>
					</tr>
				</thead>
				<tbody>
					<%
						CampeonatosDAO campeonatosDAO = new CampeonatosDAO();
						List<Campeonatos> campeonato = campeonatosDAO.pesquisarTodos();
						
						for(Campeonatos campeonatos : campeonato) {
					%>
						<tr>
							<td><%= campeonatos.getCodigo() %></td>
							<td><%= campeonatos.getNome() %></td>
							<td><%= campeonatos.getData_Inicio() %></td>
							<td><%= campeonatos.getData_Fim() %></td>
							<td><%= campeonatos.getNumero_Participantes() %></td>
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