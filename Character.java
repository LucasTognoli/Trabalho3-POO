import Item.*;

public abstract class Character extends Individual{

	private Inventory myitems;
	protected int XP;

	protected int strenght;
	protected int speed;
	protected int dexterity;
	protected int constitution;

//*************** CONSTRUTOR ********************************************//

	public Character(String name){
		
		super(name);

		this.myitems = new Inventory();
		
		this.XP = 1;
		this.strenght = 0;
		this.speed = 0;
		this.dexterity = 0;
		this.constitution = 0;
		
	}

//*************** METODOS GETTERS **************************************//

	public int getXP(){
		return this.XP;
	}
	public Inventory getInventory(){
		return this.myitems;
	}
//************** METODOS COMPLEMENTARES *********************************//
	public abstract void attack(Creature cr);

	public void showInventory(){
		System.out.println("CHARACTER:" + name);
		System.out.println("INVENTORY:");
		for(int i = 0 ; i < myitems.getNItems() ; i++){
			System.out.println(myitems.searchItem(i).getName());
		}
	}
//*************** METODOS ADD  *****************************************//

	public void addXP(int xp){
		if (this.XP + xp > 100){
			this.XP = 100;			
			return;	
		}
		this.XP += xp;
	}
//*************** METODOS SETTERS ***************************************//
	public void setStrenght(int str){
		if (str + this.speed + this.dexterity + this.constitution > 100){
			System.out.println("ERRO:A soma dos atributos ultrapassa 100");
			return;			
		}
		this.strenght = str;	
	}
	public void setSpeed(int spd){
		if (this.strenght + spd + this.dexterity + this.constitution > 100){
			System.out.println("ERRO:A soma dos atributos ultrapassa 100");
			return;			
		}		
		this.speed = spd;
	}
	public void setDexterity(int dex){
		if (this.strenght + this.speed + dex + this.constitution > 100){
			System.out.println("ERRO:A soma dos atributos ultrapassa 100");
			return;			
		}		
		this.dexterity = dex;
	}
	public void setConstitution(int con){
		if (this.strenght + this.speed + this.dexterity + con > 100){
			System.out.println("ERRO:A soma dos atributos ultrapassa 100");
			return;			
		}		
		this.constitution = con;
	}
//***********************************************************************//
	public void use(Individual individual,Item item){	//Usa a poção item no character ch.
		Item potion = myitems.searchItem(item);
		if (potion.equals(null) == true){
			System.out.println("Não existe item no inventário");
			return;
		}
		individual.addHP(potion.use());
		myitems.removeItem(item);
		
	}

}