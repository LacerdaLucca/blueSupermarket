package model;

public class Carrinho {

    private int idCar;
    private int idProd;
    private int qtn;
    private double valorTotal;

    public int getQtn() {
        return qtn;
    }

    public void setQtn(int qtn) {
        this.qtn = qtn;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }


    public Carrinho(int idProd, int qtn, double valorTotal) {
        this.idProd = idProd;
        this.qtn = qtn;
        this.valorTotal = valorTotal;
    }


    public int getIdProd() {
        return idProd;
    }

    public int getIdCar() {
        return idCar;
    }
}
