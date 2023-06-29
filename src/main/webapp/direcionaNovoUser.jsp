<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="classes.*"%>
<%@page errorPage="paginaErro.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="usuarioBean" class="classes.Usuario" scope="request"/>
        <jsp:setProperty name="usuarioBean" property="*" /> 
        <%
            if (usuarioBean.salvar()) {
        %>
         <jsp:forward page="index.html"/>
        <%
        } else {%>
          <jsp:forward page="mostrarErro.jsp"/>
        <%}%>

</body>
</html>