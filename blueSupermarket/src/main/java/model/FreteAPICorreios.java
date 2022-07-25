package model;

public class FreteAPICorreios {
    private int Codigo;
    private String Valor;
    private String PrazoEntrega;
    private String ValorSemAdicionais;
    private String ValorMaoPropria;
    private String ValorAvisoRecebimento;
    private String ValorValorDeclarado;
    private String EntregaDomiciliar;
    private String EntregaSabado;

    public FreteAPICorreios(int codigo, String valor, String prazoEntrega, String valorSemAdicionais, String valorMaoPropria, String valorAvisoRecebimento, String valorValorDeclarado, String entregaDomiciliar, String entregaSabado) {
        Codigo = codigo;
        Valor = valor;
        PrazoEntrega = prazoEntrega;
        ValorSemAdicionais = valorSemAdicionais;
        ValorMaoPropria = valorMaoPropria;
        ValorAvisoRecebimento = valorAvisoRecebimento;
        ValorValorDeclarado = valorValorDeclarado;
        EntregaDomiciliar = entregaDomiciliar;
        EntregaSabado = entregaSabado;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public String getPrazoEntrega() {
        return PrazoEntrega;
    }

    public void setPrazoEntrega(String prazoEntrega) {
        PrazoEntrega = prazoEntrega;
    }

    public String getValorSemAdicionais() {
        return ValorSemAdicionais;
    }

    public void setValorSemAdicionais(String valorSemAdicionais) {
        ValorSemAdicionais = valorSemAdicionais;
    }

    public String getValorMaoPropria() {
        return ValorMaoPropria;
    }

    public void setValorMaoPropria(String valorMaoPropria) {
        ValorMaoPropria = valorMaoPropria;
    }

    public String getValorAvisoRecebimento() {
        return ValorAvisoRecebimento;
    }

    public void setValorAvisoRecebimento(String valorAvisoRecebimento) {
        ValorAvisoRecebimento = valorAvisoRecebimento;
    }

    public String getValorValorDeclarado() {
        return ValorValorDeclarado;
    }

    public void setValorValorDeclarado(String valorValorDeclarado) {
        ValorValorDeclarado = valorValorDeclarado;
    }

    public String getEntregaDomiciliar() {
        return EntregaDomiciliar;
    }

    public void setEntregaDomiciliar(String entregaDomiciliar) {
        EntregaDomiciliar = entregaDomiciliar;
    }

    public String getEntregaSabado() {
        return EntregaSabado;
    }

    public void setEntregaSabado(String entregaSabado) {
        EntregaSabado = entregaSabado;
    }
}
