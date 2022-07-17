package model;

public class Relatorio {

    private int idProd;
    private String nomeProd;
    private long qntVendas;

    public Relatorio(int idProd, String nomeProd, long qntVendas) {
        this.idProd = idProd;
        this.nomeProd = nomeProd;
        this.qntVendas = qntVendas;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public long getQntVendas() {
        return qntVendas;
    }

    public void setQntVendas(long qntVendas) {
        this.qntVendas = qntVendas;
    }
}
