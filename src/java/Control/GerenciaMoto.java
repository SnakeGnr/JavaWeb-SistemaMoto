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
import java.util.logging.Level;
import java.util.logging.Logger;
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
        System.out.println("Chegou na servlet");

        String acao = request.getParameter("acao"); //busca o value do botao clicado
        int id_moto = Integer.valueOf(request.getParameter("id_moto"));

        if (acao.equals("Excluir")) {
            System.out.println("você clicou no botao excluir");
            System.out.println("id da moto: " + id_moto);
            
            Moto m = new Moto();
            m.setId(id_moto);
            
            try {
                MotoDao dao = new MotoDao();
                dao.remove(m);
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro ao Excluir moto servlet "+ ex.getMessage());
            }
              //redirecionamento automatico 
            RequestDispatcher rd = request.getRequestDispatcher("/consulta.jsp");

            rd.forward(request, response);
            
            
        } else if (acao.equals("Editar")) {
           //Fazer função de preencher objeto por id na Dao
           //retornar esse objeto na servlet
           //passar os parametros do objeto para a jsp alterar
            
        
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
        }

        /* 
       
         */
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
