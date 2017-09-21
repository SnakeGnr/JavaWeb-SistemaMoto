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
        <script>
            function mascara(t, mask) {
                var i = t.value.length;
                var saida = mask.substring(1, 0);
                var texto = mask.substring(i)
                if (texto.substring(0, 1) != saida) {
                    t.value += texto.substring(0, 1);
                }
            }

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
        <form >
            <table>
                <tr>   
                    <td> Nome:</td> <td>  <input type="text" name="nome"  /></td>
                </tr>
                <tr> 
                    <td> Email:</td> <td> <input type="text" name="email"   /></td>
                </tr>
                <tr>
                    <td> CPF: </td> <td><input type="text" name="cpf" onkeypress="mascara(this, '###.###.###-##')" /></td>
                </tr>
                <tr>
                    <td> DataNasc: </td> <td><input type="date" name="dataNasc" /></td>
                </tr>
                <tr> 
                    <td> Telefone: </td> <td> <input type="text" name="telefone" id="telefone" onkeypress="mascara(this, '## #####-####')"/></td>
                </tr>
                <tr> 
                    <td> CEP: </td> <td> <input type="text" name="cep" onkeypress="mascara(this, '#####-###');" maxlength="9" /></td>
                </tr>
            </table>
            <br>

            <span> <input type="submit"  value="Cadastrar" name="acao" style="background-color: green" /> </span>
            <a href="index.html"> <input type="button" value="Cancelar" style="background-color: red" /> </a>
            <!-Todo form precisa de um submit!!! pois é ele que envia as info ->
        </form>
    </body>
</html>
