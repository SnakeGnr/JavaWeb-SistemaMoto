/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.ClienteDao;
import Model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jr
 */
@WebServlet(name = "GerenciaLogin", urlPatterns = {"/GerenciaLogin"})
public class GerenciaLogin extends HttpServlet {
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
        PrintWriter out = response.getWriter();

        String cpflogin = request.getParameter("input_cpf");
        String senha = request.getParameter("input_senha");

        try {
            ClienteDao dao = new ClienteDao();
            List<Cliente> clientes = dao.consulta();

            boolean logado = false;
            for (Cliente c : clientes) {
                if (cpflogin.equals(c.getCpf()) && senha.equals(c.getSenha())) {
                    //System.out.println("Login ecxiste!");
                    logado = true;
                }
            }
            
            if(logado==true){
                //a Servlet escreve uma pagina para mostrar o Alerta e redirecionar!
                 out.print("<html> <body>"
                    + "<script> alert('Login correto! Seja bem vindo!'); location.href='index.html'; </script>"
                    + "</body> </html>");
            }else{
                out.print("<html><body>"
                    + "<script> alert('Login e/ou senha inccorretos!'); location.href='login.html'; </script>"
                    + "</body></html>");
            }                 
        } catch (ClassNotFoundException ex) {
            System.out.println("servlet>erro no login: " + ex.getMessage());
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
