/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.conexao;
import model.AlunosModel;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.WebServiceCep;

/**
 *
 * @author mmgti
 */
public class alunosDao {

    private Connection com;

    public alunosDao() {

        this.com = new conexao().getConnection();

    }

    // metodo cadastrar aluno 
    public void cadastrarAluno(AlunosModel obj) {

        try {
            
   
            // criação do comando sql    
            String sql = "insert into tb_alunos(nome,rg,cpf,email,telefone,celular"
                    + ",cep,endereco,numero,complemento,bairro,cidade,estado,plano,mensalidade,idade)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            stmt.setString(14, obj.getPlano());
            stmt.setInt(15, obj.getMensalidade());
            stmt.setInt(16, obj.getIdade());

            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro com Sucesso");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ERRO" + erro);
        }
    }

    public void alterarAluno(AlunosModel obj) {
        try {
            // criação do comando sql    
            String sql = "update tb_alunos set nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?"
                    + ",cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=?,plano=?,mensalidade=?,idade=? where id=?";

            PreparedStatement stmt = com.prepareStatement(sql); 
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            stmt.setString(14, obj.getPlano());
            stmt.setInt(15, obj.getMensalidade());
            stmt.setInt(16, obj.getIdade());
            stmt.setInt(17, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ERRO" + erro);
        }

    }

    public void excluirAluno(AlunosModel obj) {
        try {
            // criação do comando sql    
            String sql = "delete from tb_alunos where id =?";

            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ERRO" + erro);
        }

    }

    public void novoAluno() {

    }

    //metodo lista Alunos
    public List<AlunosModel> listarAlunos() {
        try {
            // criar lista ArrayList ja vem do java 
            List<AlunosModel> lista = new ArrayList<>();
            // comando sql 
            String sql = "select * from tb_alunos";

            // para executar o comando sql 
            PreparedStatement stmt = com.prepareStatement(sql);

            // todo select vc armazena em outro objeto ResuktSet classe do java 
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AlunosModel obj = new AlunosModel();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                obj.setPlano(rs.getString("plano"));
                obj.setMensalidade(rs.getInt("mensalidade"));
                obj.setIdade(rs.getInt("idade"));

                lista.add(obj);

            }

            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }

    public AlunosModel consultarPorNome(String nome) {
        try {
            String sql = "select * from tb_alunos where nome=?";
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            AlunosModel obj = new AlunosModel();
            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                obj.setPlano(rs.getString("plano"));
                obj.setMensalidade(rs.getInt("mensalidade"));
                obj.setIdade(rs.getInt("idade"));

            }

            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "matricula não encontrada ");
            return null;
        }

    }

    //metodo buscar cliente por nome 
    public List<AlunosModel> buscaAlunoPorNome(String nome) {
        try {
            // criar lista ArrayList ja vem do java 
            List<AlunosModel> lista = new ArrayList<>();
            // comando sql 
            String sql = "select * from tb_alunos where nome like ?";
            // toda tabela aonde nome seja aproximado aonde informa aqui "?"

            // para executar o comando sql 
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, nome);// seta o nome

            // todo select vc armazena em outro objeto ResuktSet classe do java 
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AlunosModel obj = new AlunosModel();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                obj.setPlano(rs.getString("plano"));
                obj.setMensalidade(rs.getInt("mensalidade"));
                obj.setIdade(rs.getInt("idade"));

                lista.add(obj);

            }

            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }

    // busca cep 
    public AlunosModel AlunosCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        AlunosModel obj = new AlunosModel();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());

            return obj;

        } else {
            JOptionPane.showMessageDialog(null, "Erro numero" + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "descricao do erro " + webServiceCep.getResultText());
            return null;
        }

    }
   
    public AlunosModel buscaporcpf(String cpf){
       try {
            String sql = "select * from tb_alunos where cpf=?";
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            AlunosModel obj = new AlunosModel();
            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                obj.setPlano(rs.getString("plano"));
                obj.setMensalidade(rs.getInt("mensalidade"));
                obj.setIdade(rs.getInt("idade"));

            }

            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "cpf não cadastrado ");
            return null;
        }
    
    }
}
