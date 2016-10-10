/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactoryDerby;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.Painel;

/**
 *
 *  
 * @author pedro
 */
public class PesquisarLogin {
        String usuario;
        String senha;

    public static boolean comunicacao(String aUsuario, String aSenha) throws SQLException, InstantiationException, IllegalAccessException{
        String usuario;
        String senha;
  
        ResultSet rs = null;
        boolean confirmacao = false;
        
        Connection con = ConnectionFactoryDerby.getConnection();
        
        PreparedStatement stmt = null;
        
        try{
            stmt =  con.prepareStatement("SELECT * FROM APP.CADASTRO ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                usuario = rs.getString("USUARIO");
                senha = rs.getString("SENHA");

                if(aUsuario.equals(usuario) && aSenha.equals(senha)){
                    confirmacao = true;
                }
            }
                if(confirmacao == false){
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
                }else{
                    Painel p = new Painel();
                    p.setLocationRelativeTo(null);
                    p.setVisible(true);
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro na consulta do banco de dados!");
                throw new RuntimeException("Erro na consulta do banco de dados: ",ex);

            }finally{
                ConnectionFactoryDerby.closseConnection(con, stmt);
                return confirmacao;
            }
        
        
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
