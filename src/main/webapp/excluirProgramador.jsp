<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="classes.*"%>
<%@page errorPage="paginaErro.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluir Programador</title>
</head>
<body>
<jsp:useBean id="programadorBean" class="classes.Programador" scope="request"/>
    <jsp:setProperty name="programadorBean" property="idFuncionario" param="idFuncionario" />
	<%
		if(programadorBean.remover()){
 	%>
	     <jsp:forward page="listarProgramadores.jsp"/>
     <%
        } else {
                out.println("<br/>Erro ao excluir programador!");
                out.println("<br/><a href=listarProgramadores.jsp> Voltar para a lista </a>");
        }
      %>

</body>
</html>