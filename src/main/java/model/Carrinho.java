package model;

public class Carrinho {

    private int idCar;
    private int idProd;

    public Carrinho(int idProd) {
        this.idProd = idProd;
    }

    public int getIdProd() {
        return idProd;
    }

    public int getIdCar() {
        return idCar;
    }
}
