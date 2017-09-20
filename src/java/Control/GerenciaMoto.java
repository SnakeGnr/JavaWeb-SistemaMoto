/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.MotoDao;
import Model.Moto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SnakeGnr <adaognr.lima@gmail.com>
 */
@WebServlet(name = "GerenciaMoto", urlPatterns = {"/GerenciaMoto"})
public class GerenciaMoto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //System.out.println("Chegou na servlet");

        String acao = request.getParameter("acao"); //busca o value do botao clicado
        

        if (acao.equals("Excluir")) {
            int id_moto = Integer.valueOf(request.getParameter("id_moto"));
            System.out.println("você clicou no botao excluir");
            System.out.println("id da moto: " + id_moto);

            Moto m = new Moto();
            m.setId(id_moto);

            try {
                MotoDao dao = new MotoDao();
                dao.remove(m);
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro ao Excluir moto servlet " + ex.getMessage());
            }
            //redirecionamento automatico 
            RequestDispatcher rd = request.getRequestDispatcher("/consulta.jsp");

            rd.forward(request, response);

        } else if (acao.equals("Cadastrar")) {
            String modelo = request.getParameter("modelo");
            String marca = request.getParameter("marca");
            String potencia = request.getParameter("potencia");
            String ano = request.getParameter("ano");
            String valor = request.getParameter("valor");

            Moto moto = new Moto();

            moto.setModelo(modelo);
            moto.setMarca(marca);
            moto.setPotencia(Integer.valueOf(potencia));
            moto.setAno(Integer.valueOf(ano));
            moto.setValor(Double.valueOf(ano));

            try {
                MotoDao dao = new MotoDao();
                dao.Cadastra(moto);
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar moto: " + e.getMessage());
            }

            //redirecionamento automatico 
            RequestDispatcher rd = request.getRequestDispatcher("/consulta.jsp");

            rd.forward(request, response);
        } else if (acao.equals("Editar")) {
            int id_moto = Integer.valueOf(request.getParameter("id_moto"));
            String modelo = request.getParameter("modelo");
            String marca = request.getParameter("marca");
            String potencia = request.getParameter("potencia");
            String ano = request.getParameter("ano");
            String valor = request.getParameter("valor");
            
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<body>");
            out.println("   <form action=\"GerenciaMoto\" method=\"post\">\n" +
"            <table>\n" +
"                <tr>   \n" +
"                    <td> ID:</td> <td>  <input type=\"text\" name=\"id\" readonly=\"true\" value="+id_moto +"  /></td>\n" +
"                </tr>\n" +
"                <tr>   \n" +
"                    <td> Marca:</td> <td>  <input type=\"text\" name=\"marca\" value=\"marca\" /></td>\n" +
"                </tr>\n" +
"                <tr> \n" +
"                    <td> Modelo:</td> <td> <input type=\"text\" name=\"modelo\" /></td>\n" +
"                </tr>\n" +
"                 <tr>\n" +
"                    <td> Potência: </td> <td><input type=\"text\" name=\"potencia\" /></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td> Ano: </td> <td><input type=\"text\" name=\"ano\" /></td>\n" +
"                </tr>\n" +
"                <tr> \n" +
"                    <td> Valor: </td> <td> <input type=\"text\" name=\"valor\" /></td>\n" +
"                </tr>\n" +
"            </table>\n" +
"            <br>\n" +
"\n" +
"            <span> <input type=\"submit\" value=\"Cadastrar\" name=\"acao\" style=\"background-color: green\" /> </span>\n" +
"            <a href=\"index.jsp\"> <input type=\"button\" value=\"Cancelar\" style=\"background-color: red\" /> </a>\n" +
"        </form> ");
           
            out.println("</body>");
            out.println("</html>");

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
