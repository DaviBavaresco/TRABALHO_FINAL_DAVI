<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*"%>
<%@page import="classes.*"%>
<%@page errorPage="paginaErro.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	   <jsp:useBean id="programadorBean" class="classes.Programador" scope="request"/>
    <%  
        List<Programador> lista=programadorBean.buscarTodos();  
        request.setAttribute("listaReq",lista);  
    %>  
    <table border="1">
      <c:forEach var="programador" items="${listaReq}">
    	<tr>
           <td> Nome: ${programador.getNome()} </td>
           <td>Endereco: ${programador.getEndereco()}</td>
           <td>Email: ${programador.getEmail()}</td>
           <td>Salario: ${programador.getSalario()}</td>
           <td>CPF: ${programador.getCpf()}</td>
           <td> Linguagem de Programação: ${programador.getLinguagemProg()} </td>
           <td>Projetos: ${programador.getProjetos()}</td>
   	   	     <td><a href="excluirProgramador.jsp?idFuncionario=${programador.getIdFuncionario()}"> Excluir </a></td>
   	   	   <td><a href="editarProgramador.jsp?idFuncionario=${programador.getIdFuncionario()}"> Editar </a></td>
   	   	   
    	</tr>
      </c:forEach>
    </table>
<a href="index.html"> Voltar para a página principal </a> 
</body>
</html>