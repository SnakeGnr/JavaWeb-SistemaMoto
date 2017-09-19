
package Dao;

import Jdbc.ConexaoBD;
import Model.Moto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author SnakeGnr<adaognr.lima@gmail.com>
 */
public class MotoDao {
    
     private Connection con;

    public MotoDao() throws ClassNotFoundException {
        try {
            this.con = new ConexaoBD().getConnection();
            System.out.println("Conectado!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro na Conexão.");
        }

    }

    public void Cadastra(Moto m) throws SQLException {

        String sql = "Insert into Moto (modelo,marca , potencia, ano, valor)"
                + " values (?,?,?,?, ?) ";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, m.getModelo());
            st.setString(2, m.getMarca());
            st.setInt(3, m.getAno());
            st.setInt(4, m.getPotencia());
            st.setDouble(5, m.getValor());

            st.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            con.close();
        }
    }
    
       public List<Moto> consulta() {

        try {
            //Cria um ArayList para receber os carros cadastrados
            List<Moto> motos = new ArrayList<Moto>();
            PreparedStatement st = this.con.prepareStatement("SELECT * FROM Moto");
            //Executa uma consulta 
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                //Percorre Linha por Linha para preencher o Objeto
                Moto m = new Moto();
                m.setId(rs.getInt("id"));
                m.setMarca(rs.getString("marca"));
                m.setModelo(rs.getString("modelo"));
                m.setAno(rs.getInt("ano"));
                m.setValor(rs.getDouble("valor"));

                motos.add(m);
            }
            rs.close();
            st.close();

            //Mostra o ArrayList dps de receber os carros do BD
            return motos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
   }
       
    public void remove(Moto m) {
        try {
            PreparedStatement st = con.prepareStatement("delete from Moto where id =?");
            st.setInt(1, m.getId());
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
