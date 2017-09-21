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
        <link rel="shortcut icon" href="img/favicon.ico">
        <link rel="icon" type="image/gif" href="img/animated_favicon1.gif">
        <title>Consulta de Motos</title>

        <script>
            function confirmaExcluir() {
                var id = document.getElementById('idDaMoto').value; //busca o value do elemento pelo seu ID
                
                //cria um alert do tipo 'confirm'
                var resposta = confirm("ATENÇÂO! \n\ Deseja realmente excluir a moto de ID: " + id + " ? \n\
               \n\ A operação não poderá ser desfeita!");
                if (resposta == true) {
                    return true; //se a resposta for SIM, continua..
                } else {
                    return false; //se a resposta for NAO, para!
                }

            }
        </script>


    </head>
    <body>
        <h3>Motos Cadastradas: </h3>
        <div class="MenuBotoes"> 
            <a href='index.html'><input type="button" value="Home"></a>
            <a href='cadastro.html'><input type="button" value="Cadastrar Moto"></a>
            <a href='consulta.jsp'><input type="button" value="Gerenciar Motos"></a>       
            <a href='cadastroCliente.jsp'><input type="button" value="Cadastrar Cliente"></a>
            <a href='consultaCliente.jsp'><input type="button" value="Gerenciar Clientes"></a>      
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
                    <td><%=m.getId()%></td>
                    <td><%=m.getMarca()%></td>
                    <td><%=m.getModelo()%></td>
                    <td><%=m.getPotencia()%></td>
                    <td><%=m.getAno()%></td>    
                    <td><%=m.getValor()%></td>
                    <td><input type="submit" value="Editar" name="acao" > </td>
                    <td><input type="submit" value="Excluir" name="acao" onclick="return confirmaExcluir()"  > </td>
                <input type="hidden" value="<%=m.getId()%>" name="id_moto" id="idDaMoto" >
                </tr> 
            </form>
            <% }%>  

        </table>


    </body>
</html>
