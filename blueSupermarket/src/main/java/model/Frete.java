package model;

public class Frete {
    private String cep;
    private String valorFrete;
    private String prazo;

    public Frete(String cep,String valor, String prazo) {
        this.cep = cep;
        this.valorFrete=valor;
        this.prazo = prazo;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getValorFrete() {
        return valorFrete;
    }
    public void setValorFrete(String valorFrete) {
        this.valorFrete = valorFrete;
    }
    public String getPrazo() {
        return prazo;
    }
    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

}
