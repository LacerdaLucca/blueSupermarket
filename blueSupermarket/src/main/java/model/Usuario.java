package model;

public class Usuario {

    private String nome;
    private String cpf;
    private String senha;
    private String endereco;
    private String cep;

    public Usuario(String nome, String cpf, String senha, String cep, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.cep = cep;
        this.endereco = endereco;

    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", senha='" + senha + '\'' +
                ", endereço='" + endereco + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
