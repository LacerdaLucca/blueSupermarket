package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

public class CEP implements Serializable {
    // pripriedades do CEP
    public String cep;
    public String logradouro;
    public String complemento;
    public String bairro;
    public String localidade;
    public String uf;
    public String ibge;
    public String gia;

    /**
     * Cria um novo CEP vazio
     */
    public CEP() {

    }

    /**
     * Cria um novo CEP completo
     * @param CEP
     * @param Logradouro
     * @param Complemento
     * @param Bairro
     * @param Localidade
     * @param Uf
     * @param Ibge
     * @param Gia
     */
    public CEP(String CEP, String Logradouro, String Complemento, String Bairro, String Localidade, String Uf, String Ibge, String Gia) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
    }

    /**
     * Cria um novo CEP parcial
     * @param Logradouro
     * @param Localidade
     * @param Uf
     */
    public CEP(String Logradouro, String Localidade, String Uf) {
        this.logradouro = Logradouro;
        this.localidade = Localidade;
        this.uf = Uf;
    }

    public String getCEP() {
        return cep;
    }

    public void setCEP(String CEP) {
        this.cep = CEP;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        uf = uf;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        gia = gia;
    }

    @Override
    public String toString() {
        return "CEP{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", ibge='" + ibge + '\'' +
                ", gia='" + gia + '\'' +
                '}';
    }
}
