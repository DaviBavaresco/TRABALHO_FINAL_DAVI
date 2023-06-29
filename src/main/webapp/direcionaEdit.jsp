<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="classes.*"%>
<%@page errorPage="paginaErro.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Confirmação de Edição</title>
    </head>
    <body>    
        <jsp:useBean id="programadorBean" class="classes.Programador" scope="request"/>
        <jsp:setProperty name="programadorBean" property="*" /> 
        <%
           
            if (programadorBean.atualizar()) {
         %>
            <jsp:forward page="listarProgramadores.jsp"/>
        <%}else {%>
             <jsp:forward page="mostrarErro.jsp"/>
        <%}%>
    </body>
</html>
