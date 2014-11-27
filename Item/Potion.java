package Item;

public abstract class Potion extends Item{
	private int restorepts;
	
	public Potion(String name, double price, int restorepts){	//Construtor
		super(name,price);
		this.restorepts = restorepts;
	}
	public Potion(Potion p){	//Construtor de copia
		super(p.getName(),p.getPrice());
		this.restorepts = p.restorepts;
	}
	public int getRestorePts(){
		return this.restorepts;
	}
	public int getDefensePts(){
		return 0;
	}
	public int getAttackPts(){
		return 0;
	}
	public abstract int use();	//Metodo virtual.
}