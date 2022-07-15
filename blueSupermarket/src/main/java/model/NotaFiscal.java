package model;

import com.google.gson.Gson;

public class NotaFiscal {

    private int id;
    private String cpfUsuario;
    private int idCarrinho;
    private static Empresa empresa;

    public NotaFiscal(int id, int idCarrinho, String cpfUsuario){
        empresa = new Empresa("Blue Company","00.000.000/0001-01","1");
        this.id = id;
        this.cpfUsuario = cpfUsuario;
        this.idCarrinho = idCarrinho;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toJson(){
        return new Gson().toJson(this);
    }
}
