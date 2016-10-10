/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author marcos
 */
public class Diretorio {
    public static String diretorio;
    public static File arquivo = null;
    public static JFileChooser chooser;
    
    public static String arquivo() throws IOException {
        int result = 0;
        chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter(".jar","jar"));
        chooser.setAcceptAllFileFilterUsed(false);
        
        result = chooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            diretorio = chooser.getSelectedFile().getParent();
            return diretorio;
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o"
                    + " diretório do banco de dados. Encerrando software!");
            return diretorio;
        }
    }
}