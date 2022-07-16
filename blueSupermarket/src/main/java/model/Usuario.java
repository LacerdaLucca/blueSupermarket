package model;
public class Usuario {

    private String nome;
    private String cpf;
    private String senha;
    private String endereco;
    private String cep;

    public Usuario(String nome, String cpf, String senha, String cep, String endereco) {
        setNome(nome);
        setCpf(cpf);
        setSenha(senha);
        setCep(cep);
        setEndereco(endereco);
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!verificaNome(nome))
            throw new RuntimeException();
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(!verificaCPF(cpf))
            throw new RuntimeException();
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(!verificaSenha(senha))
            throw new RuntimeException();
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
        if(!verificaCep(cep))
            throw new RuntimeException();
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
    private boolean verificaCPF(String cpf){
        boolean cpfEhValido = true;
        if(cpf.length() != 11){
            cpfEhValido = false;
        }
        if(cpfEhValido) {
            cpfEhValido = validaPrimeiroDigito(cpf);
        }
        if(cpfEhValido){
            cpfEhValido = validaSegundoDigito(cpf);
        }
        return cpfEhValido;
    }

    private boolean validaPrimeiroDigito(String cpf) {
        boolean digitoValido = false;
        int soma = 0, dig = 0, j = 10;
        for (int i = 0; i < 9; i++) {
            soma += (int)(cpf.charAt(i)-48)*j;
            j--;
        }
        int resp = (11-(soma % 11));
        if(resp < 10){
            dig = resp;
        }
        int dig10 = (int)(cpf.charAt(9)-48);
        if(dig == dig10)
            digitoValido = true;
        return digitoValido;
    }
    private boolean validaSegundoDigito(String cpf) {
        boolean digitoValido = false;
        int soma = 0, dig = 0, j = 11;
        for (int i = 0; i < 10; i++) {
            soma += (int)(cpf.charAt(i)-48)*j;
            j--;
        }
        int resp = (11 - (soma % 11));
        if(resp < 10){
            dig = resp;
        }
        int dig10 = (int)(cpf.charAt(10)-48);
        if(dig == dig10)
            digitoValido = true;
        return  digitoValido;
    }

    private boolean verificaNome(String nome) {
        String digitos = "(.*\\d.*)";
        return !nome.matches(digitos);
    }
    private boolean verificaSenha(String senha) {
        String senhaValida = "^(?=.*\\d)" //Pelo menos 1 digito
                + "(?=.*[a-z])(?=.*[A-Z])" // Pelo menos 1 minuscula e 1 maiuscula
                + "(?=.*[@#$%^&+=])" // Pelo menos 1 char especial
                + "(?=\\S+$)" // Sem espaço em branco
                + ".{8,20}$"; // De 8 a 20 chars
        return senha.matches(senhaValida);
    }
    private boolean verificaCep(String cep) {
        String digitos = "(.*\\d.*).{8}";
        return cep.matches(digitos);
    }
}
