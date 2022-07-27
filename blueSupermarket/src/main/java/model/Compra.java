package model;

import java.time.LocalDate;

public class Compra {
    private int idCarrinhos;
    private int idProdutos;
    private String nomeProd;
    private int qtn;
    private String cpfUsuario;
    private String cep;
    private double valorFrete;
    private int prazoEntrega;
    private double valorTotal;

    private String dataCompra;

    public Compra(){

    }

    public Compra(int idCarrinhos, int idProdutos, String nomeProd, int qtn, String cpfUsuario, String cep, double valorFrete, int prazoEntrega, double valorTotal, String dataCompra) {
        this.idCarrinhos = idCarrinhos;
        this.idProdutos = idProdutos;
        this.nomeProd = nomeProd;
        this.qtn = qtn;
        this.cpfUsuario = cpfUsuario;
        this.cep = cep;
        this.valorFrete = valorFrete;
        this.prazoEntrega = prazoEntrega;
        this.valorTotal = valorTotal;
        this.dataCompra = dataCompra;
    }

    public Compra(int idCarrinhos, int idProdutos, String nomeProd, String cep, double valorFrete, int prazoEntrega, String dataCompra) {
        this.idCarrinhos = idCarrinhos;
        this.idProdutos = idProdutos;
        this.nomeProd = nomeProd;
        this.cep = cep;
        this.valorFrete = valorFrete;
        this.prazoEntrega = prazoEntrega;
        this.dataCompra = dataCompra;
    }

    public void setIdCarrinhos(int idCarrinhos) {
        this.idCarrinhos = idCarrinhos;
    }

    public int getIdCarrinhos() {
        return idCarrinhos;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public int getQtn() {
        return qtn;
    }

    public void setQtn(int qtn) {
        this.qtn = qtn;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String idUsuario) {
        this.cpfUsuario = idUsuario;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public int getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(int prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    public double getValorTotal() { return valorTotal;}

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    @Override
    public String toString() {
        return "{\"nomeProduto\":\"" + nomeProd +
                "\",\"quantidade\":\"" + qtn +
                "\"}";
    }
}
