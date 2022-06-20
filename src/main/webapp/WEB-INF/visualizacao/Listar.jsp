<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Usuários Cadastrados</title>
</head>
<body>
	<table border="1">
		<thead>
	      	<tr>
	            <th>ID</th>
	            <th>Evento</th>
	            <th>Horario</th>
	            <th colspan="2">Ação</th>
	        </tr>
	    </thead>
	    <tbody>
			<c:forEach var="eventos" items="${eventos}">
				<tr>
					<td>${eventos.posicao}</td>
					<td>${eventos.atividade}</td>
					<td>${eventos.horario}</td>
					<td><a href="ToDoServlet?direcionador=editar&id=${eventos.posicao}">Editar</a></td>
					<td><a href="ToDoServlet?direcionador=concluido&id=${eventos.posicao}">Concluido</a></td>
				</tr>
			</c:forEach>
		</tbody>
	 </table>
</body>
</html>