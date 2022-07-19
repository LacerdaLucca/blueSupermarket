package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Produto extends Quantidade{
    private int ID;
	private String nome;
    private String desc;
    private double preco;
    private long quantidade;
    private java.util.Date validade;
    private boolean promocao;
    private double valorTotal;

    //construtor
    public Produto(int ID, String nome, String desc, double preco, long quant, Date validade, double valorTotal ){
        this.ID=ID;
        this.nome= nome;
        this.desc = desc;
        this.preco = preco;
        this.quantidade =quant;
        this.validade=validade;
        this.valorTotal = valorTotal;
        try {
        	this.promocao = getPromocao();
        }catch(ParseException e){
        	System.out.println("ERRO AO OBTER PROMOCAO! (method getPromocao())");
       	System.out.println(e.getMessage());
       }
        
    }
    
    //getters



    public int getID() {
        return ID;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPreco() {
        return preco;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public boolean isPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }

    public double getValorTotal() {return valorTotal; }

    public void setValorTotal(double valorTotal) {this.valorTotal = valorTotal;}

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
    	Produto clone = new Produto(getID(),this.nome,this.desc,this.preco,getQuant(),this.validade, this.valorTotal);
    	return clone;
    }
}
