package model;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Produto extends Quantidade{
    private int idProd;
	private String nome;
    private String desc;
    private double preco;

    private long quantidade;
    private java.util.Date validade;
    private boolean promocao;
    private double valorTotal;

    //construtor


    public Produto(int ID, String nome) {
        this.idProd = ID;
        this.nome = nome;
    }

    public Produto(int idProd, String nome, String desc, double preco, long quant, Date validade, double valorTotal){
        this.idProd=idProd;
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

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
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
        DecimalFormat df = new DecimalFormat("#,##");
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tmp = sdf.format(date);
        java.util.Date agora = sdf.parse(tmp);
        if(this.validade!=null && !this.promocao){
            long diff = this.validade.getTime() - agora.getTime();
            TimeUnit time = TimeUnit.DAYS;
            long vencimento = time.convert(diff, TimeUnit.MILLISECONDS);
            if(vencimento < 14 && vencimento >0) {
                double precoPromocional = this.preco*0.7;
                setPreco(Double.parseDouble(df.format(precoPromocional)));
                this.promocao = true;
            }else if(vencimento <=0) {
                this.setQuant(0);
            }
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
    		this.setIdProd(this.getQuant()-quant);
    		return cloneProduto();
    	}
    	
    }
    
    //clona o produto
    private Produto cloneProduto() {
    	Produto clone = new Produto(getIdProd(),this.nome,this.desc,this.preco,getQuant(),this.validade, this.valorTotal);
    	return clone;
    }
}
