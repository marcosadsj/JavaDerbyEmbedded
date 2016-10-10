package model.metodos;

/**
 *
 * @author Cassi
 */
public class Emprestimo {
    String nomeUsuario;
    String nomeObra;
    int dataEmprestimo;
    int dataDevolucao;
    
    public String getNomeUsuario(){
        return nomeUsuario;
    }
    
    public String getNomeObra(){
        return nomeObra;
    }
    
    public int getDataEmprestimo(){
        return dataEmprestimo;
    }
    
    public int getDataDevolucao(){
        return dataDevolucao;
    }
}
