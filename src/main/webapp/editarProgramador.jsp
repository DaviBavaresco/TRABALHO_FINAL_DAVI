<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="classes.*"%>
<%@page errorPage="paginaErro.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Programador</title>
</head>
<body>
<jsp:useBean id="programadorBean" class="classes.Programador" scope="request"/>
     <jsp:setProperty name="programadorBean" property="idFuncionario" param="idFuncionario" />
        <%  
        Programador programador = programadorBean.buscarID(); 
        String id = String.valueOf(programadorBean.getIdFuncionario());	
        %>  
    
        <h1>Editar Programador</h1>
        <form method ="POST" action="direcionaEdit.jsp">
        <input type="hidden" name="idFuncionario" value="<%=id%>"/>  
            <p>
                Nome:    <br/>
                <input type="text" name="nome" value="<%=programador.getNome()%>">
            </p>
            <p>
                Endereço: <br/>
                <input type="text" name="endereco" value="<%=programador.getEndereco()%>">
            </p>
            <p>
                Email: <br/>
                <input type="text" name="email" value="<%=programador.getEmail()%>">
            </p>
            <p>
                Salario: <br/>
                <input type="text" name="salario" value="<%=programador.getSalario()%>">
            </p>
            <p>
                Cpf: <br/>
                <input type="text" name="cpf" value="<%=programador.getCpf()%>">
            </p>
             <p>
                Linguagem de Programação: <br/>
                <input type="text" name="linguagemProg" value="<%=programador.getLinguagemProg()%>">
            </p>
            <p>
                Projetos: <br/>
                <input type="text" name="projetos" value="<%=programador.getProjetos()%>">
            </p>
           

 
            <p>
                <input type="submit" value="OK">
            </p>
            <p>
                <input type="reset" value="Limpar">
            </p>
        </form> 

</body>
</html>