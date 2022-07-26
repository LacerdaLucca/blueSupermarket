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
    private double valorTotal =0;

    private String dataCompra;


    public Compra(){

    }
//rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(7),rs.getDouble(8),rs.getInt(9),rs.getDouble(11)
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


    public Compra(int idCarrinhos, int idProdutos, String nomeProd,int qtn, String cep, double valorFrete, int prazoEntrega, double valorTotal) {
        this.idCarrinhos = idCarrinhos;
        this.idProdutos = idProdutos;
        this.nomeProd = nomeProd;
        this.qtn = qtn;
        this.cep = cep;
        this.valorFrete = valorFrete;
        this.prazoEntrega = prazoEntrega;
        this.dataCompra = dataCompra;
        this.valorTotal = valorTotal;

    }




    public int getIdCarrinhos() {
        return idCarrinhos;
    }

    public void setIdCarrinhos(int idCarrinhos) {
        this.idCarrinhos = idCarrinhos;
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
