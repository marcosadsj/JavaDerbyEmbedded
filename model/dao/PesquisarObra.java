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

/**
 *
 *  
 * @author pedro
 */
public class PesquisarObra {
        public static Obra ob = null;
        public static String pesquisaAnterior = null;
        public static Editora ed = null;
        public static DefaultListModel <String> listaDeAutores; 
        public static DefaultListModel <Obra> listaDeObras;
        public static boolean resultPesquisa = true;
        
    public static void comunicacao(String aTextoPesquisa) throws SQLException, InstantiationException, IllegalAccessException{
        
        String textoPesquisa = null;
        ResultSet rs = null;
        boolean confirmacao = false;
        
        ob = new Obra();
        
        listaDeObras = new DefaultListModel<>();       
        listaDeAutores = new DefaultListModel<>();
         
        Connection con = ConnectionFactoryDerby.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt =  con.prepareStatement("SELECT * FROM APP.OBRA");
            rs = stmt.executeQuery();
             
            while(rs.next()){
                
                String name = rs.getString("NOME");
                String author = rs.getString("AUTOR");
                String editora = rs.getString("EDITORA");
                
                if(aTextoPesquisa.equalsIgnoreCase(name) ||
                    aTextoPesquisa.equalsIgnoreCase(author) ||
                    aTextoPesquisa.equalsIgnoreCase(editora))
                {
                    ob.setNomeObra(rs.getString("NOME"));
                    ob.setAutores(rs.getString("AUTOR"));
                    ob.setQtdExemplar(rs.getInt("QUANTIDADE"));
                    ob.setNome(rs.getString("EDITORA"));
 
                    confirmacao = true;
                    
                    if (aTextoPesquisa.equals(pesquisaAnterior)){
                        
                        JOptionPane.showMessageDialog(null,"Livro já pesquisado!");
                        resultPesquisa = false;
                    
                    }else{    
                            listaDeAutores.addElement(ob.getAutores());

                        try{
                            
                            listaDeObras.addElement(ob);
                            pesquisaAnterior = aTextoPesquisa;
                            resultPesquisa = true;
                            
                        }catch(ArrayIndexOutOfBoundsException ex){
                            JOptionPane.showMessageDialog(null,"Excesso na quantidade de itens pesquisados"+ex.getMessage());
                        }
                    }
                }                           
            }
            if(confirmacao == false){
                JOptionPane.showMessageDialog(null, "Livro não encontrado");
            }
                
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na consulta do banco de dados!");
            throw new RuntimeException("Erro na consulta do banco de dados: ",ex);

        }finally{
            ConnectionFactoryDerby.closseConnection(con, stmt);
        }
    }
}
