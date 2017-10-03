<%-- 
    Document   : editar
    Created on : 29/09/2017, 11:31:42
    Author     : Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
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
        <form action="GerenciaMoto" method="post" >
            <table>
                <tr>   
                    <td> ID:</td> <td>  <input type="text" name="id_moto"  value="<%request.getAttribute("moto"); %>" required  /></td>
                </tr>
                <tr>   
                    <td> Marca:</td> <td>  <input type="text" name="marca" required  /></td>
                </tr>
                <tr> 
                    <td> Modelo:</td> <td> <input type="text" name="modelo" required   /></td>
                </tr>
                <tr>
                    <td> Potência: </td> <td><input type="text" name="potencia" required/></td>
                </tr>
                <tr>
                    <td> Ano: </td> <td><input id="teste" type="text" name="ano" required /></td>
                </tr>
                <tr> 
                    <td> Valor: </td> <td> <input type="text" name="valor" required/></td>
                </tr>
            </table>
            <br>

            <span> <input type="submit"  value="Atualizar" name="acao" style="background-color: green" /> </span>
            <a href="consulta.jsp"> <input type="button" value="Cancelar" style="background-color: red" /> </a>
            <!-Todo form precisa de um submit!!! pois é ele que envia as info ->
        </form>
    </body>
</html>

