package Item;

public final class ManaPotion extends Potion{
	public ManaPotion(String name,double price,int restorepts){	//Construtor
		super(name,price,restorepts);
	}
	public int use(){
		return this.getRestorePts();	//Retorna o valor de MP a ser restaurado para o character que chamou o metodo
	}
}