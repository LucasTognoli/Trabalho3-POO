package Item;

public class Weapon extends Item{
	protected int attackpts;
	protected double range;

	public Weapon(String name,double price,int attackpts,double range){	//Construtor
		super(name,price);	//Chama construtor da classe pai
		this.attackpts = attackpts;
		this.range = range;
	}
	public Weapon(Weapon weapon){	//Construtor de copia
		super(weapon.getName(),weapon.getPrice());
		this.attackpts = weapon.getAttackPts();
		this.range = weapon.getRange();
	}
	public int getAttackPts(){
		return this.attackpts;
	}
	public int getDefensePts(){
		return 0;
	}
	public double getRange(){
		return this.range;
	}
	public int use(){	//Equipa a arma.
		this.setIseq(true);
		return 0;
	}
}