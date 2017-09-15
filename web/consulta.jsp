<%-- 
    Document   : consulta
    Created on : 27/04/2016, 15:02:06
    Author     : SnakeGnr
--%>

<%@page import="java.util.List"%>
<%@page import="Dao.MotoDao"%>
<%@page import="Model.Moto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Motos</title>
    </head>
    <body>
        <h3>Motos Cadastradas: </h3>
        <div class="MenuBotoes"> 
            <a href='index.html'><input type="button" value="Home"></a>
            <a href='cadastro.html'><input type="button" value="Cadastrar Moto"></a>
            <a href='consulta.jsp'><input type="button" value="Gerenciar Motos"></a>       
        </div>
        <br>
        <br>
        <br>
        <table border='1'>
            <tr> 
                <th>ID</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Potência cc</th>
                <th>Ano</th>
                <th>Valor</th>
                <th>Editar</th>
                <th>Excluir</th>

            </tr>
            <% MotoDao dao = new MotoDao();
                List<Moto> motos = dao.consulta();

                for (Moto m : motos) {
            %>
            
            <form action="GerenciaMoto" method="Post">
            <tr>
                <td name="id_moto" value="<%=m.getId()%>"><%=m.getId()%></td>
                <td><%=m.getMarca()%></td>
                <td><%=m.getModelo()%></td>
                <td><%=m.getPotencia()%></td>
                <td><%=m.getAno()%></td>    
                <td><%=m.getValor()%></td>
                <td><input type="submit" value="Editar" name="acao" id="Excluir_<%=m.getId()%>" > </td>
                <td><input type="submit" value="Excluir" name="acao" id="Alterar_<%=m.getId()%>" > </td>
                <input type="hidden" value="<%=m.getId()%>" name="id_moto" >
            </tr> 
            </form>
            <% }%>  
           
        </table>


    </body>
</html>
