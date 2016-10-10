package model.metodos;

/**
 *
 * @author Cassi
 */
public class Obra {
    String nomeObra;
    String autores;
    int qtdExemplar;
    String nomeEditora;
    
    public String getNomeObra(){
        return nomeObra;
    }
    
     public int getQtdExemplar(){
        return qtdExemplar;
    }
    public String getAutores(){
        return autores;
    }

    public void setNomeObra(String nomeObra) {
        this.nomeObra = nomeObra;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public void setQtdExemplar(int qtdExemplar) {
        this.qtdExemplar = qtdExemplar;
    }
        
    public String getNomeEditora(){
        return nomeEditora;
    }
    
    public void setNome(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

   

   
}
