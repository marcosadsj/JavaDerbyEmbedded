package model.metodos;
/**
 *
 * @author Cassi
 */
public class Usuario {
    String nome;
    int telefone;
    int cpf;
    String endereco;
    String usuario;
    String senha;
    String confUsuario;
    String confSenha;

    public String getNome(){
        return nome;
    }
    
    public int getTelefone(){
        return telefone;
    }
    
    public int getCpf(){
        return cpf;
    }
    
    public String getEndereco(){
        return endereco;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getConfUsuario() {
        return confUsuario;
    }

    public String getConfSenha() {
        return confSenha;
    }
     
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setConfUsuario(String confUsuario) {
        this.confUsuario = confUsuario;
    }

    public void setConfSenha(String confSenha) {
        this.confSenha = confSenha;
    }
       
    public void Emprestimo(){
        //emprestimo do livro
    }
    
    public void Cadastrar(){
        //cadastro do usuario
        
    }
}
