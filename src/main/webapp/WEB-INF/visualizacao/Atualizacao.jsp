<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualização de evento</title>
</head>
<body>
	
	<div class="user titulo">
    	<h1>Atualização:</h1>
    </div>
    
    <form action="ToDoServlet" method="POST">
    	<input type="hidden" name="id" value="${eventos.posicao}"></input>
		<label for="name">Evento</label>
		<input type="text" name="atividade" placeholder="Digite o evento"value="${eventos.atividade}"> <br>
		<label for="fase">Horario</label>
		<input type="text" name="horario" placeholder="Digite o horario" value="${eventos.horario}"> <br>
		<button type="submit">Atualizar</button>
    </form>
</body>
</html>