package model;

import java.util.List;

public class Carrinho {
    private int idCarrinhos;
    private int idProdutos;
    private List<Produto> listProdutos;
    private int qtn;
    private String cpfUsuario;
    private String cep;
    private double valorFrete;
    private int prazoEntrega;
    private double valorTotal;

    public int getIdCarrinhos() {
        return idCarrinhos;
    }

    public void setIdCarrinhos(int idCarrinhos) {
        this.idCarrinhos = idCarrinhos;
    }

    public List<Produto> getListProdutos() {
        return listProdutos;
    }

    public void setListProdutos(List<Produto> listProdutos) {
        this.listProdutos = listProdutos;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
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

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
