<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/style.css">
<title>Editar Lembrete</title>
</head>
<body>

	<section id="cadastro">
		<img src="img/lembrete.png" alt="">
		<h2>Vamos editar o seu lembrete !</h2>
		<hr>

		<form action="atualizar" method="POST" name="editar">

			<div id="entrada">
				<h1>Codigo do lembrete</h1>
				<input type="text"
					value="<%out.print(request.getAttribute("id"));%>" required
					readonly="readonly" name="id"> <br>
				<h1>Titulo do lembrete</h1>
				<input type="text"
					value="<%out.print(request.getAttribute("titulo"));%>" required
					name="titulo"> <br>
			</div>
			<div id="textArea">


				<textarea name="msg" cols="60" rows="15" style="resize: none">
                
                <%
                                out.print(request.getAttribute("msg"));
                                %>
                
                </textarea>
			</div>

			<div id="enviar">
				<input type="submit">


			</div>
		</form>
	</section>
</body>
</html>