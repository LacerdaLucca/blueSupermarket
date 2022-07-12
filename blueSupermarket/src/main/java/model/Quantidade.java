package main.java.models;
 
public class Quantidade {
	   private int ID;
	   private int quant;
	    
	    public Quantidade() {
	    	this.ID = 0;
	    	this.quant = 0;
	    }
	    
	    protected void setID(int ID){
	        this.ID = ID;
	    }

	    protected int getID(){
	        return this.ID;
	    }

	    protected void setQuant(int quant){
	        this.quant = quant;
	    }

	    protected int getQuant(){
	        return this.quant;
	    }
}
