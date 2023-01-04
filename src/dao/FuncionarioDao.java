/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.FuncionarioModel;
import model.WebServiceCep;
import view.Login;
import view.Menu;

/**
 *
 * @author mmgti
 */
public class FuncionarioDao {

    private java.sql.Connection com;

    public FuncionarioDao() {

        this.com = new conexao().getConnection();

    }
    // metodo cadastrar

    

    public void alterarFuncionario(FuncionarioModel obj) {
        try {
            // criação do comando sql    
            String sql = "update tb_funcionarios set nome=?,rg=?,cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?"
                    + ",cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=?,salario=? where id=?";

            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_Acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());
            stmt.setDouble(17, obj.getSalario());
            stmt.setInt(18, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ERRO" + erro);
        }

    }

    public void excluirFuncionario(FuncionarioModel obj) {
        try {
            // criação do comando sql    
            String sql = "delete from tb_funcionarios where id =?";

            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ERRO" + erro);
        }

    }

    public void novoFuncionario() {

    }

    public List<FuncionarioModel> buscaFuncionarioPorNome(String nome) {
        try {
            // criar lista ArrayList ja vem do java 
            List<FuncionarioModel> lista = new ArrayList<>();
            // comando sql 
            String sql = "select * from tb_funcionarios where nome like ?";
            // toda tabela aonde nome seja aproximado aonde informa aqui "?"

            // para executar o comando sql 
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, nome);// seta o nome

            // todo select vc armazena em outro objeto ResuktSet classe do java 
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FuncionarioModel obj = new FuncionarioModel();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_Acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                obj.setSalario(rs.getDouble("salario"));

                lista.add(obj);

            }

            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }

    public FuncionarioModel consultarPorNome(String nome) {
        try {
            String sql = "select * from tb_funcionarios where nome=?";
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            FuncionarioModel obj = new FuncionarioModel();
            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_Acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                obj.setSalario(rs.getDouble("salario"));

            }

            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "matricula não encontrada ");
            return null;
        }

    }

    // busca por cep 
    public FuncionarioModel FuncionarioCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        FuncionarioModel obj = new FuncionarioModel();

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

    public List<FuncionarioModel> listarFuncionario() {
        try {
            // criar lista ArrayList ja vem do java 
            List<FuncionarioModel> lista = new ArrayList<>();
            // comando sql 
            String sql = "select * from tb_funcionarios";

            // para executar o comando sql 
            PreparedStatement stmt = com.prepareStatement(sql);

            // todo select vc armazena em outro objeto ResuktSet classe do java 
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FuncionarioModel obj = new FuncionarioModel();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_Acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                obj.setSalario(rs.getDouble("salario"));

                lista.add(obj);

            }

            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }
    // metodo que efetua login
    public void efetuarLogin(String email, String senha ){
        
        try {
            // comando SQL
            String sql = "select * from tb_funcionarios where email=? and senha=?";
             // para executar o comando sql 
            PreparedStatement stmt = com.prepareStatement(sql);
            stmt.setString(1,email);
            stmt.setString(2,senha);
            
            // recebe o retorno do select 
            ResultSet rs = stmt.executeQuery();
            //se ele consegui percorrer esse registro
            if(rs.getString("nivel_acesso").equals("admin")){
             // usuario logo 
             JOptionPane.showMessageDialog(null ,"Seja bem vindo ao Sistema! ");
             Menu tela = new Menu();// chamo a tela 
             tela.usuariologado = rs.getString("nome");// nome da coluna no banco 
             //desabilitar os menus arruma ainda**
          // tela.
             tela.setVisible(true);
            
            }else if (rs.getString("nivel_acesso").equals("Usuario")) {
             JOptionPane.showMessageDialog(null ,"Dados incorretos! ");
            }
            
           
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null ,"Erro:! "+erro);
        }
    
    
    }

    public void cadastrarFuncionario(FuncionarioModel obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
