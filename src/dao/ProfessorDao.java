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
import model.ProfessoresModel;
import model.VisitanteModel;
import model.WebServiceCep;

/**
 *
 * @author mmgti
 */
public class ProfessorDao {

    private Connection com;

    public ProfessorDao() {

        this.com = new conexao().getConnection();
    }

    public void cadastrar(ProfessoresModel obj) {

        try {
            String sql = "insert into tb_professor(nome,cpf,endereco,numero,bairro,"
                    + "cep,telefone,hora,valor)value(?,?,?,?,?,?,?,?,?)";

            // conectar ao banco e organizar comando sql 
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getEndereco());
            stmt.setInt(4, obj.getNumero());
            stmt.setString(5, obj.getBairro());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getTelefone());
            stmt.setInt(8, obj.getHoras());
            stmt.setDouble(9, obj.getValor());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, " Professor cadastrado com Sucesso");
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }

    }

    public void excluirProfessor(ProfessoresModel obj) {
        try {
            // criação do comando sql    
            String sql = "delete from tb_professor where id =?";

            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ERRO" + erro);
        }

    }

    public void novoProfessor() {

    }

    public List<ProfessoresModel> buscaProfessorPorNome(String nome) {
        try {
            // criar lista ArrayList ja vem do java 
            List<ProfessoresModel> lista = new ArrayList<>();
            // comando sql 
            String sql = "select * from tb_professor where nome like ?";
            // toda tabela aonde nome seja aproximado aonde informa aqui "?"

            // para executar o comando sql 
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, nome);// seta o nome

            // todo select vc armazena em outro objeto ResuktSet classe do java 
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProfessoresModel obj = new ProfessoresModel();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setHoras(rs.getInt("hora"));
                obj.setBairro(rs.getString("bairro"));
                obj.setValor(rs.getDouble("valor"));

                lista.add(obj);

            }

            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }

    public ProfessoresModel consultarProfessorPorNome(String nome) {
        try {
            String sql = "select * from tb_professor  where nome=?";
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            ProfessoresModel obj = new ProfessoresModel();
            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setHoras(rs.getInt("hora"));
                obj.setValor(rs.getDouble("valor"));

            }

            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "professor não encontrado ");
            return null;
        }

    }

    public ProfessoresModel ProfessorCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        ProfessoresModel obj = new ProfessoresModel();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setBairro(webServiceCep.getBairro());

            return obj;

        } else {
            JOptionPane.showMessageDialog(null, "Erro numero" + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "descricao do erro " + webServiceCep.getResultText());
            return null;
        }

    }
      public List<ProfessoresModel> listarProfessor() {
        try {
            // criar lista ArrayList ja vem do java 
            List<ProfessoresModel> lista = new ArrayList<>();
            // comando sql 
            String sql = "select * from tb_professor";

            // para executar o comando sql 
            PreparedStatement stmt = com.prepareStatement(sql);

            // todo select vc armazena em outro objeto ResuktSet classe do java 
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProfessoresModel obj = new ProfessoresModel();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));               
                obj.setCpf(rs.getString("cpf"));            
                obj.setTelefone(rs.getString("telefone"));          
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));    
                obj.setHoras(rs.getInt("hora"));
                obj.setBairro(rs.getString("bairro"));
                obj.setValor(rs.getDouble("valor"));

                lista.add(obj);

            }

            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }
       public void alterarProfessor(ProfessoresModel obj) {
        try {
            // criação do comando sql    
            String sql = "update tb_professor set nome=?,cpf=?,telefone=?"
                    + ",cep=?,endereco=?,numero=?,bairro=?,hora=?,valor=? where id=?";

            PreparedStatement stmt = com.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());      
            stmt.setString(2, obj.getCpf()); 
            stmt.setString(3, obj.getEndereco());
            stmt.setInt(4, obj.getNumero());
            stmt.setString(5, obj.getBairro());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getTelefone());                                  
            stmt.setInt(8,obj.getHoras());
            stmt.setDouble(9, obj.getValor());
            stmt.setInt(10, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ERRO" + erro);
        }

    }
      
}
