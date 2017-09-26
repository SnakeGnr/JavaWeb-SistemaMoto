<%-- 
    Document   : cadastroCliente
    Created on : 20/09/2017, 10:10:40
    Author     : SnakeGnr <adaognr.lima@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de Clientes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="img/favicon.ico">
        <link rel="icon" type="image/gif" href="img/animated_favicon1.gif">
     

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
        <form name="formCliente" onsubmit="return validaCPF(formCliente.cpf)" >
            <table>
                <tr>   
                    <td> Nome:</td> <td>  <input type="text" name="nome" required  /></td>
                </tr>
                <tr> 
                    <td> Email:</td> <td> <input type="text" name="email" required   /></td>
                </tr>
                <tr>
                    <td> CPF: </td> <td><input type="text" name="cpf"  onKeyPress="maskCPF(formCliente.cpf);return SomenteNumero(event)" maxlength="14" required/></td>
                </tr>
                <tr>
                    <td> DataNasc: </td> <td><input type="date" maxlength="9" name="dataNasc" onblur="" required/></td>
                </tr>
                <tr> 
                    <td> Telefone: </td> <td> <input type="text" name="telefone" id="telefone" onkeypress="mascara(this, '## #####-####');
                        return SomenteNumero(event)" maxlength="13" required /></td>
                </tr>
                <tr> 
                    <td> CEP: </td> <td> <input type="text" name="cep" onkeypress="mascara(this, '#####-###');
                        return SomenteNumero(event)" onblur="" maxlength="9" required /></td>
                </tr>
            </table>
            <br>

            <span> <input type="submit"  value="Cadastrar" name="acao"  style="background-color: green" /> </span>
            <a href="index.html"> <input type="button" value="Cancelar" style="background-color: red" /> </a>
            <!-Todo form precisa de um submit!!! pois é ele que envia as info ->
        </form>
    </body>
    <script language="JavaScript" src="js/myscripts.js"></script>    
</html>
