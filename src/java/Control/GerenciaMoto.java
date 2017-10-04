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
import java.util.List;
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
        PrintWriter out = response.getWriter();
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
            RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");

            rd.forward(request, response);

        } else if (acao.equals("Cadastrar")) {

            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            String potencia = request.getParameter("potencia");
            String ano = request.getParameter("ano");
            String valor = request.getParameter("valor");

            Moto moto = new Moto();

            moto.setModelo(modelo);
            moto.setMarca(marca);
            moto.setPotencia(Integer.valueOf(potencia));
            moto.setAno(Integer.valueOf(ano));
            moto.setValor(Double.valueOf(valor));

            try {
                MotoDao dao = new MotoDao();
                dao.Cadastra(moto);
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar moto: " + e.getMessage());
            }

            out.println("<html><body><script>alert('Moto Cadastrada com sucesso!'); location.href='consulta.jsp';</script></body></html>");

            //redirecionamento automatico 
            RequestDispatcher rd = request.getRequestDispatcher("/consulta.jsp");

            rd.forward(request, response);

        } else if (acao.equals("Editar")) {
            int id_moto = Integer.valueOf(request.getParameter("id_moto"));
            System.out.println("Você clicou no botão editar, id da moto: " + id_moto);
            Moto escolhida = new Moto();

            try {
                MotoDao dao = new MotoDao();
                List<Moto> motos = dao.consulta();
                //monta o objeto moto a partir do id_moto
                for (Moto m : motos) {
                    if (id_moto == m.getId()) {
                        escolhida = m;
                    }
                }

                System.out.println("dados da moto: " + escolhida.getId() + " / " + escolhida.getModelo());

                //passa o objeto moto escolhida para a jsp
                request.setAttribute("moto", escolhida);

                RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");

                rd.forward(request, response);

            } catch (ClassNotFoundException ex) {

            }

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
