/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.AlunosModel;
import model.PlanoModel;
import model.VisitanteModel;

/**
 *
 * @author mmgti
 */
public class VisitanteDao {
    
    private Connection com;

    public VisitanteDao() {

        this.com = new conexao().getConnection();
    }
     public void cadastrar(VisitanteModel obj) {
        try {
            String sql = "insert into tb_visitante(nome,cpf,valor)value(?,?,?)";

            // conectar ao banco e organizar comando sql 
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setDouble(3, obj.getValor());
          

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, " Visitante cadastrado com Sucesso");
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }

    }
      public List<VisitanteModel> buscaVisitantePorNome(String nome) {
        try {
            // criar lista ArrayList ja vem do java 
            List<VisitanteModel> lista = new ArrayList<>();
            // comando sql 
            String sql = "select * from tb_visitante where nome like ?";
            // toda tabela aonde nome seja aproximado aonde informa aqui "?"

            // para executar o comando sql 
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, nome);// seta o nome

            // todo select vc armazena em outro objeto ResuktSet classe do java 
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                VisitanteModel obj = new VisitanteModel();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));             
                obj.setValor(rs.getDouble("valor"));
             
                

                lista.add(obj);

            }

            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }
      
       public void excluirVisitante(VisitanteModel obj) {
        try {
            // criação do comando sql    
            String sql = "delete from tb_visitante where id =?";

            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ERRO" + erro);
        }

    }
        public void alterarVisitante(VisitanteModel obj) {
        try {
            // criação do comando sql    
            String sql = "update tb_visitante set nome=?,cpf=?,valor=? where id=?";
                 

            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, obj.getNome());      
            stmt.setString(2, obj.getCpf());         
            stmt.setDouble(3, obj.getValor());
            stmt.setInt(4, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ERRO" + erro);
        }

    }

}
