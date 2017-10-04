<%-- 
    Document   : editar
    Created on : 29/09/2017, 11:31:42
    Author     : Jr
--%>

<%@page import="Model.Moto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>

<% //estou criando uma variável do mesmo do tipo do atributo 
    Moto moto = new Moto();
    moto = (Moto) request.getAttribute("moto");
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de Motos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="img/favicon.ico">
        <link rel="icon" type="image/gif" href="img/animated_favicon1.gif">
        <script>
                 
        </script>
    </head>


    <body>

        <div class="MenuBotoes"> 
            <a href='index.html'><input type="button" value="Home"></a>
            <a href='cadastro.html'><input type="button" value="Cadastrar Moto"></a>
            <a href='consulta.jsp'><input type="button" value="Gerenciar Motos"></a>       
            <a href='cadastroCliente.jsp'><input type="button" value="Cadastrar Cliente"></a>
            <a href='consultaCliente.jsp'><input type="button" value="Gerenciar Clientes"></a>     
        </div>
        <br>
        <br>
        <% %>
        
        <form action="GerenciaMoto" method="post" >
            <table>
                 <input type="hidden" name="id_moto" value="<%=moto.getId()%>"  id="id_moto"  >
                <tr>   
                    <td> ID:</td> <td>  <input type="text" value="<%= moto.getId() %>"  disabled="true"   required  /></td>
                </tr>
                <tr>   
                    <td> Marca:</td> <td>  <input type="text" name="marca" value="<%= moto.getMarca() %>"required  /></td>
                </tr>
                <tr> 
                    <td> Modelo:</td> <td> <input type="text" name="modelo"value="<%=moto.getModelo() %>" required   /></td>
                </tr>
                <tr>
                    <td> Potência: </td> <td><input type="text" name="potencia"  value="<%=moto.getPotencia()%>" required/></td>
                </tr>
                <tr>
                    <td> Ano: </td> <td><input id="teste" type="text" name="ano" value="<%=moto.getAno() %>"required /></td>
                </tr>
                <tr> 
                    <td> Valor: </td> <td> <input type="text" name="valor" value="<%=moto.getValor() %>" required/></td>
                </tr>
            </table>
            <br>

            <input type="submit"  value="Atualizar" name="acao" style="background-color: green" />
            <a href="consulta.jsp"> <input type="button" value="Cancelar" style="background-color: red" /> </a>
            <!-Todo form precisa de um submit!!! pois é ele que envia as info ->
        </form>
    </body>
</html>

