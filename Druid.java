import Item.*;

public class Druid extends Character implements Spells{
	protected int wisdom;

	public Druid(String name,int wisdom){	//Construtor
		super(name);
		this.wisdom = wisdom;
	}
	protected int getDefensePoints(){	//Retorna os pontos de defesa consideranto items e atributos
		double dp=0;
		double xp=0;
		for(int i = 0 ; i < this.getInventory().getNItems() ; i++){
			Item aux = this.getInventory().searchItem(i);
			if ( this.getInventory().isEquiped(aux) == true)	//Somente items equipados são somados
				dp += this.getInventory().searchItem(i).getDefensePts();
		}
		xp = (double)(this.XP/6);
		dp = ((this.constitution*.6 + this.dexterity*.1 + this.speed*.3) + dp)*xp;
		return (int)dp + (wisdom);
	}
	protected int getAttackPoints(){	//Retorna os pontos de attack considerando items e atributos
		return 0;
	}

	public void attack(Character ch){
		double rand = Math.random(); 			//Missing Chance (de 0 a 0.9999999)
		if (this.MP < 5){
			return;
		}
		this.addMP(-5);
		if(rand < 0.15){
			ch.addHP(-(this.FireStrike()));
			return;
		}
		if(rand < 0.30){
			ch.addHP(-(this.WaterStrike()));
			return;
		}
		if(rand < 0.50){
			ch.addHP(-(this.EarthStrike()));
			return;
		}
		if (rand < 1){
			ch.addHP(-(this.AirStrike()));
			return;
		}
	}

	public void attack(Creature cr){
		double rand = Math.random(); 			//Missing Chance (de 0 a 0.9999999)
		if (this.MP < 5){
			return;
		}
		this.addMP(-5);
		if(rand < 0.25){
			System.out.println("FireStrike");
			if (cr.getElement() == Element.fire){
				return;
			}
			cr.addHP(-(this.FireStrike()));
			return;
		}
		if(rand < 0.50){
			System.out.println("WaterStrike");
			if (cr.getElement() == Element.water){
				return;
			}
			cr.addHP(-(this.WaterStrike()));
			return;
		}
		if(rand < 0.75){
			System.out.println("EarthStrike");
			if (cr.getElement() == Element.earth){
				return;
			}
			cr.addHP(-(this.EarthStrike()));
			return;
		}
		if (rand < 1){
			System.out.println("AirStrike");
			if (cr.getElement() == Element.air){
				return;
			}
			cr.addHP(-(this.AirStrike()));
			return;
		}
	}

	public void addWisdom(int wisdom){
		this.wisdom += wisdom;
	}


	public int AirStrike(){
		return (int)(wisdom*0.10 + XP/4);
	}	
	public int EarthStrike(){
		return (int)(wisdom*0.30 + XP/4);
	}
	public int WaterStrike(){
		return (int)(wisdom*0.50 + XP/4);
	}
	public int FireStrike(){
		return (int)(wisdom*0.70 + XP/4);
	}
	public void Healing(Individual individual){
		individual.addHP((int)(this.wisdom*0.4 + XP/3));
	}
	public void IntenseHealing(Individual individual){
		individual.addHP((int)(this.wisdom*0.6 + XP/3));
	}
}