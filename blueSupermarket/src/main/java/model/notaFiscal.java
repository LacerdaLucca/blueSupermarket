package model;

import com.google.gson.Gson;

public class notaFiscal {
    private String nomeUsuario;
    private String cpfUsuario;
    private int idCarrinho;
    private static Empresa empresa;

    public notaFiscal(String nomeUsuario, String cpfUsuario, int idCarrinho){
        empresa = new Empresa("Blue Company","00.000.000/0001-01","1");
        this.nomeUsuario = nomeUsuario;
        this.cpfUsuario = cpfUsuario;
        this.idCarrinho = idCarrinho;
    }

    public String toJson(){
        return new Gson().toJson(this);
    }
}
