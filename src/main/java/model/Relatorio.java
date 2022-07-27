package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Relatorio)) return false;
        Relatorio relatorio = (Relatorio) o;
        return getIdProd() == relatorio.getIdProd() && getQntVendas() == relatorio.getQntVendas() && getNomeProd().equals(relatorio.getNomeProd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProd(), getNomeProd(), getQntVendas());
    }
}
