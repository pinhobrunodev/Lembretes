<%@page import="beans.LembreteBeans"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    

    
    <%
    
    ArrayList<LembreteBeans> list = (ArrayList<LembreteBeans>) request.getAttribute("registros");
    
    %>
<head>
  <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="pt-br">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lembretes - Home</title>
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="icon" href="img/sino.png">
</head>

<body id="white">
    <h2>Seus Lembretes</h2>
    <div class="adicionar">
        <a href="AdicionarLembrete.html"><button id="adicionar">Adicionar Lembrete</button></a>
    </div>

    <div id="conteudo">
    <%for(int i = 0 ;i <list.size();i++){%> 
        <div class="item">
            <div id="ID">
                <h3>ID</h3>
                <%=list.get(i).getId()%>
            </div>
            <div id="nome">
                <h3>TITULO</h3>
                  <%=list.get(i).getTitulo()%>
            </div>
            <div id="texto">
                <h3>MENSAGEM</h3>
       		 <%=list.get(i).getMsg()%>
            </div>
            <div id="buttons">
                <button id="edit"><a href="select?id=<%=list.get(i).getId()%>">Editar</a> </button>
                <button id="excluir"><a href="delete?id=<%=list.get(i).getId()%>">Excluir</a> </button>
            </div>
            <div id="apagar">
                
            </div>
        </div>
        <% }%>
    </div>
    
</body>
</html>