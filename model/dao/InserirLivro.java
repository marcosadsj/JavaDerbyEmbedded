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
public class InserirLivro {
    
    public static void comunicacao(String aNome, String aAutor, String aEditora,
        int aQuantidade,int aCnpj) throws SQLException, InstantiationException, IllegalAccessException{
        //INSERT INTO OBRA (nome,autor,editora,quantidade)VALUES('VIDA E MORTE SEVERINA','MELO NETO/JOÃO CABRAL DE ALFAGUARA','OBJETIVA',7);
        Connection con = ConnectionFactoryDerby.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO APP.OBRA (NOME,AUTOR,EDITORA,QUANTIDADE,CNPJ)VALUES(?,?,?,?,?)");
            stmt.setString(1,aNome );
            stmt.setString(2, aAutor);
            stmt.setString(3, aEditora);
            stmt.setInt(4,aQuantidade);
            stmt.setInt(5,aCnpj);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Nova obra salva com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na inserção!");
            throw new RuntimeException("Erro na inserção: ",ex);
            
        }finally{
            ConnectionFactoryDerby.closseConnection(con, stmt);
        }

    }
}
