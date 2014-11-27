package Item;

public final class HealthPotion extends Potion{
	public HealthPotion(String name,double price,int restorepts){	//Construtor
		super(name,price,restorepts);
	}
	public int use(){	//Retorna o valor de HP ser somado na vida do character.
		return this.getRestorePts();
	}

}