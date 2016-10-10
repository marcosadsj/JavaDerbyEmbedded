/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import view.Login;
/**
 *
 * @author pedro
 */
public class ConnectionFactoryDerby {
  
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String URL = "jdbc:derby:database";
    private static final String USER = "derby";
    private static final String PASS = "derby";
    private static String USERDIR;
    private static boolean inicializado = false;
    
    public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException{
    
        try {
            if(inicializado == false){
                JOptionPane.showMessageDialog(null,"Por favor, selecione o arquivo"
                        + " .jar do software para localizar"
                        + " o banco de dados");
                USERDIR = Diretorio.arquivo();
                inicializado = true;
                if(USERDIR == "Erro")
                {
                   JOptionPane.showMessageDialog(null,"Erro na conexão com o Banco de Dados: ");
                   inicializado = false;
                }
            }
            System.setProperty("derby.system.home", USERDIR);
            
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL,USER,PASS);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Erro na conexão com o Banco de Dados: "+ex.getMessage());
            throw new RuntimeException("Erro na conexão com o Banco de Dados: ",ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionFactoryDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
            return DriverManager.getConnection(URL,USER,PASS);
    }
    
    public static void  closeConnection(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
              throw new RuntimeException("Nao foi possivel fechar a conexão: ",ex);
            }
        }
    }
    public static void closseConnection(Connection con, PreparedStatement stmt){
        
        closeConnection(con);
        
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Nao foi possivel fechar a conexão statement: ",ex);
            }
        }
    }
    public static void closseConnection(Connection con, PreparedStatement stmt, ResultSet res){
        
        closseConnection(con, stmt);
        
        if(res != null){
            try {
                res.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Nao foi possivel fechar a conexão resultset: ",ex);
            }
        }
    }
    public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException{
        Icon icon = new ImageIcon("stock_people.png");
        
        JOptionPane.showMessageDialog(null,"Conectando ao banco de dados...Aguarde");
        
        getConnection();
        
        Login l = new Login();
        JOptionPane.showMessageDialog(null,"Conectado!");    
        l.setLocationRelativeTo(null);
        l.setVisible(true);
    }
}
