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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.metodos.Editora;
import model.metodos.Obra;
import view.Painel;

/**
 *
 *  
 * @author pedro
 */
public class ReservarLivro {
        public static Obra ob = null;
        public static String pesquisaAnterior = null;
        public static Editora ed = null;
        public static DefaultListModel <String> listaDeAutores; 
        public static DefaultListModel <Obra> listaDeObras;
        public static boolean resultPesquisa = true;
        
    public static void comunicacao(String aReserva) throws SQLException, InstantiationException, IllegalAccessException{
        
        int quantidade = 0;
        String textoAutor = null;
        String nome = null;
        ResultSet rs = null;
        boolean confirmacao = false;
        PreparedStatement stmt = null;
        Connection con = ConnectionFactoryDerby.getConnection();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM APP.OBRA");
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                if(aReserva.equalsIgnoreCase(rs.getString("AUTOR")))
                {
                    textoAutor = rs.getString("AUTOR");
                    quantidade = rs.getInt("QUANTIDADE");
                    nome = rs.getString("NOME");
                }
            }
            stmt.close();
            
            try
            {
                quantidade -= 1;
                stmt =  con.prepareStatement("UPDATE APP.OBRA SET QUANTIDADE = "+quantidade+" WHERE AUTOR = '"+nome+"'");
                JOptionPane.showMessageDialog(null, "Reserva Realizada com sucesso!");
                   
                confirmacao = true;
            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "Livro não disponível,"+e.getMessage());
            }
                
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na consulta do banco de dados!");
            throw new RuntimeException("Erro na consulta do banco de dados: ",ex);

        }finally{
            ConnectionFactoryDerby.closseConnection(con, stmt);
        }
    }
}
