/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.Connection;


/**
 *
 * @author mmgti
 */
public class conexao {
   
    // metodo estabelcer conexao 
  
    public Connection getConnection(){
    
        try {
          
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbacademia?allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC&useSSL=false","academia","123");
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }

    public void ButtonBuscaAlunoActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }
    
}
