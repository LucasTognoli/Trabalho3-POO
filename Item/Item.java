package Item;

public abstract class Item{

	private String name;
	private double price;
//*************** CONSTRUTOR ********************************************//

	public Item(String name,double price){	//Construtor
		this.name = name;
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
	public abstract int use();	//Metodo virtual
}