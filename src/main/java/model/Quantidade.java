package model;
 
public class Quantidade {
	   private int idQtn;
	   private int quant;
	    
	    public Quantidade() {
	    	this.idQtn = 0;
	    	this.quant = 0;
	    }

	public int getIdQtn() {
		return idQtn;
	}

	public void setIdQtn(int idQtn) {
		this.idQtn = idQtn;
	}

	protected void setQuant(int quant){
	        this.quant = quant;
	    }

	    protected int getQuant(){
	        return this.quant;
	    }
}
