package Item;

public abstract class Item{

	private String name;
	private double price;
	private boolean iseq;
//*************** CONSTRUTOR ********************************************//

	public Item(String name,double price){	//Construtor
		this.name = name;
		this.iseq = false;
		if (price > 0 )	//Evita preços negativos
			this.price = price;
		else
			this.price = 0;
	}
	public Item(Item i){	//Construtor de copia
		this.name = i.name;
		this.price = i.price;
	}
//*************** METODOS GETTERS **************************************//

	public String getName(){
		return this.name;
	}
	public double getPrice(){
		return this.price;
	}
	public abstract int getAttackPts();	//Metodo virtual
	public abstract int getDefensePts();	//Metodo virtual

//***************** METODOS AUXILIARES **********************************//
	public boolean isEquiped(){	//Retorna se o item esta ou nao equipado
		return this.iseq;
	}
	public abstract int use();	//Metodo virtual
	public void setIseq(boolean bool){
		this.iseq = bool;
	}
}