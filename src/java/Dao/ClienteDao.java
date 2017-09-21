/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Jdbc.ConexaoBD;
import Model.Cliente;
import Model.Moto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SnakeGnr <adaognr.lima@gmail.com>
 */
public class ClienteDao {
    
    private Connection con;

    public ClienteDao() throws ClassNotFoundException {
        try {
            this.con = new ConexaoBD().getConnection();
            System.out.println("Conectado!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro na Conexão.");
        }

    }

    public void Cadastra(Cliente c) throws SQLException {

        String sql = "Insert into Cliente (nome, email, cpf, dataNasc, fone, cep)"
                + " values (?,?,?,?, ?) ";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, c.getNome());
            st.setString(2, c.getEmail());
            st.setString(3, c.getCpf());
            st.setString(4, c.getDataNasc());
            st.setString(5, c.getFone());
            st.setString(6, c.getCep());
            

            st.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            con.close();
        }
    }
    
       public List<Cliente> consulta() throws SQLException {

        try {
            //Cria um ArayList para receber os carros cadastrados
            List<Cliente> clientes = new ArrayList<Cliente>();
            PreparedStatement st = this.con.prepareStatement("SELECT * FROM Cliente");
            //Executa uma consulta 
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                //Percorre Linha por Linha para preencher o Objeto
                Cliente c = new Cliente();
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setDataNasc(rs.getString("dataNasc"));
                c.setFone(rs.getString("fone"));
                c.setCep(rs.getString("cep"));

                clientes.add(c);
            }
            rs.close();
            st.close();

            //Mostra o ArrayList dps de receber os carros do BD
            return clientes;

        } catch (SQLException e) {
            System.out.println("Erro ao retornar lista do BD");
            throw new RuntimeException(e);
        }finally{
            con.close();
        }
   }
       
    public void remove(Cliente c) {
        try {
            PreparedStatement st = con.prepareStatement("delete from CLiente where id_cliente =?");
            st.setInt(1, c.getId_cliente());
            st.execute();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    } 
    
     public Moto PesquisaID(int id_moto) {

        try {
            PreparedStatement st = this.con.prepareStatement("SELECT * FROM Moto");
            //Executa uma consulta 
            ResultSet rs = st.executeQuery();
            Moto m = new Moto();
            while (rs.next()) {
                //Percorre Linha por Linha para preencher o Objeto
                if(id_moto == rs.getInt("id") ){
                
                
                m.setId(rs.getInt("id"));
                m.setMarca(rs.getString("marca"));
                m.setModelo(rs.getString("modelo"));
                m.setAno(rs.getInt("ano"));
                m.setValor(rs.getDouble("valor"));
                
                }
               
            }
            rs.close();
            st.close();
            return m;
            //Mostra o ArrayList dps de receber os carros do BD
            

        } catch (SQLException e) {
            System.out.println("erro na pesquisa por ID"+ e.getMessage());
            throw new RuntimeException(e);
        }
   }
       
}
