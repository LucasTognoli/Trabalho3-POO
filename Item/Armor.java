package Item;

public class Armor extends Item{
	protected int defensepts;
	protected double weight;	//Peso da armadura

	public Armor(String name,double price,int defensepts,double weight){	//Construtor
		super(name,price);	//Chama o construtor da classe pai
		this.defensepts = defensepts;
		this.weight = weight;
	}
	public Armor(Armor armor){	//Construtor de copia
		super(armor.getName(),armor.getPrice());
		this.defensepts = armor.getDefensePts();
		this.weight = armor.getWeight();
	}
	public int getDefensePts(){
		return this.defensepts;
	}
	public int getAttackPts(){
		return 0;
	}
	public double getWeight(){
		return weight;
	}
	public int use(){	//Este metodo equipa a armadura no character
		this.setIseq(true);
		return 0;
	}
}