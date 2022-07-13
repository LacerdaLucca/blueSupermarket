package main.java.models;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import main.java.models.Quantidade;

public class Produto extends Quantidade{
	private String nome;
    private String desc;
    private double preco;
    private java.util.Date validade;
    private boolean promocao;

    //construtor
    public Produto(int ID,String nome,String desc,double preco, int quant,java.util.Date validade){
        this.setID(ID);
        this.nome= nome;
        this.desc = desc;
        this.preco = preco;
        this.setQuant(quant);
        this.validade=validade;
        try {
        	getPromocao();
        }catch(ParseException e){
        	System.out.println("ERRO AO OBTER PROMOCAO! (method getPromocao())");
        	System.out.println(e.getMessage());
        }catch(NullPointerException e) {}
        
    }
    
    //getters
    public int getID() {
    	return this.getID();
    }
    
    public String getNome() {
    	return this.nome;
    }
    
    public String getDesc() {
    	return this.desc;
    }
    
    public double getPreco() {
    	return this.preco;
    }
    
    public int getQuant() {
    	return this.getQuant();
    }
    
    public java.util.Date getValidade(){
    	return this.validade;
    }
    
    public boolean getPromocao() throws ParseException{
    	this.promocao = false;
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tmp = sdf.format(date);
		java.util.Date agora = sdf.parse(tmp);
		int vencimento = this.validade.compareTo(agora);
		if(vencimento < 7 && vencimento >0) {
			setPreco(this.preco*0.7);
			this.promocao = true;
		}else if(vencimento <=0) {
			this.setQuant(0);
		}
		
		return this.promocao;
	}
    
    public void setPreco(double preco) {
    	this.preco = preco;
    }
    
    //obtem o produto e atualiza a quantidade de itens presentes na tabela
    public Produto getProduto(int quant) {
    	if(this.getQuant()==0) {
    		throw new RuntimeException("PRODUTO ESGOTADO!");
    	}else if (quant > this.getQuant()) {
    		throw new RuntimeException("DEMANDA MAIOR DO QUE A OFERTA!");
    	}else {
    		this.setID(this.getQuant()-quant);
    		return cloneProduto();
    	}
    	
    }
    
    //clona o produto
    private Produto cloneProduto() {
    	Produto clone = new Produto(getID(),this.nome,this.desc,this.preco,getQuant(),this.validade);
    	return clone;
    }
}
