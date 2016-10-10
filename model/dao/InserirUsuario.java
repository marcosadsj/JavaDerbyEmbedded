/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactoryDerby;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 *  
 * @author pedro
 */
public class InserirUsuario {
    
    public static void comunicacao(String aNome, int aTelefone, int aCpf,
        String aEndereco, String aUsuario, String aSenha) throws SQLException, InstantiationException, IllegalAccessException{
        
        Connection con = ConnectionFactoryDerby.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO APP.CADASTRO(NOME,TELEFONE,CPF,ENDERECO,USUARIO,SENHA)VALUES(?,?,?,?,?,?)");
            stmt.setString(1,aNome );
            stmt.setInt(2, aTelefone);
            stmt.setInt(3, aCpf);
            stmt.setString(4, aEndereco);
            stmt.setString(5, aUsuario);
            stmt.setString(6, aSenha);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na inserção!");
            throw new RuntimeException("Erro na inserção: ",ex);
            
        }finally{
            ConnectionFactoryDerby.closseConnection(con, stmt);
        }
        
    }
}
