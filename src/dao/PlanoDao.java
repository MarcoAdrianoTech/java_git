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
import view.Plano;

/**
 *
 * @author mmgti
 */
public class PlanoDao {

    private Connection com;

    public PlanoDao() {

        this.com = new conexao().getConnection();

    }

    //metodo cadastra o plano 
    public void cadastrar(PlanoModel obj) {
        try {
            String sql = "insert into tb_planos(descricao,valor,alu_id)value(?,?,?)";

            // conectar ao banco e organizar comando sql 
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getValor());
            stmt.setInt(3, obj.getAlunos().getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, " Plano cadastrado com Sucesso");
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }

    }

    public List<PlanoModel> listarPlano() {

        try {
            List<PlanoModel> lista = new ArrayList<>();

            String sql = "select p.id,p.descricao,p.valor,f.nome from tb_planos as p "
                    + " inner join tb_alunos as f on(p.alu_id = f.id)";

            // conectar ao banco e organizar comando sql 
            PreparedStatement stmt = com.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PlanoModel obj = new PlanoModel();// objeto para pega os cados 
                AlunosModel f = new AlunosModel();// objeto para pega chava estrangeira 

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setValor(rs.getDouble("p.valor"));

                // objeto chave estrangeria 
                f.setNome(rs.getString("f.nome"));

                obj.setAlunos(f);

                lista.add(obj);

            }

            return lista;

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "erro" + erro);
            return null;
        }

    }

    public void excluirPlano(PlanoModel obj) {
        try {
            // criação do comando sql    
            String sql = "delete from tb_planos where id =?";

            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ERRO" + erro);
        }

    }

    public List<PlanoModel> buscaPlanoPorNome(String nome) {
        try {
            // criar lista ArrayList ja vem do java 
            List<PlanoModel> lista = new ArrayList<>();
            // comando sql 
            String sql = "select p.id,p.descricao,p.valor,f.nome from tb_planos as p "
                    + " inner join tb_alunos as f on(p.alu_id = f.id)where p.descricao=?";
            // toda tabela aonde nome seja aproximado aonde informa aqui "?"

            // para executar o comando sql 
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, nome);// seta o nome

            // todo select vc armazena em outro objeto ResuktSet classe do java 
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PlanoModel obj = new PlanoModel();

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setValor(rs.getDouble("p.valor"));

                lista.add(obj);

            }

            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }

    public PlanoModel consultarPlanoPorNome(String nome) {
        try {
            //List<PlanoModel> lista = new ArrayList<>();

            String sql = "select p.id,p.descricao,p.valor,f.nome from tb_planos as p "
                    + " inner join tb_alunos as f on(p.alu_id = f.id)where p.descricao=?";

            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            //Plano obj = new Plano();

            PlanoModel obj = new PlanoModel();
            AlunosModel f = new AlunosModel();

            if (rs.next()) {

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setValor(rs.getDouble("p.valor"));

                f.setNome(rs.getString("f.nome"));
                obj.setAlunos(f);

            }
            return obj;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não encontrado Erro" + erro);
            return null;
        }
    }

    public void alterar(PlanoModel obj) {

        try {
            String sql = "update tb_planos set descricao=?,valor=?,alu_id=? where id=?";
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getValor());
            stmt.setInt(3, obj.getAlunos().getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não encontrado Erro" + e);

        }

    }

    public PlanoModel buscaPorCodigo(int id) {
        try {
            //1 passo - criar o sql , organizar e executar.

            String sql = "select * from tb_planos where id =  ?";

            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setInt(1, id);
             
            ResultSet rs = stmt.executeQuery();
            PlanoModel obj = new PlanoModel();
            AlunosModel f = new AlunosModel();

            if (rs.next()) {

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setValor(rs.getDouble("p.valor"));

                f.setNome(rs.getString("f.nome"));
                obj.setAlunos(f);

            }
            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Plano  não encontrado!");
            return null;
        }
    }
}
