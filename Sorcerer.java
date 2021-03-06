/*
Classe Sorcer tem mais dano em magias que a Druid.
O getAttackPoints retorna 0 pois nao tem como o Sorcer atacar fisicamente.
*/
import Item.*;

public class Sorcerer extends Character implements Spells{
	protected int wisdom;

	public Sorcerer(String name,int wisdom){	//Construtor
		super(name);
		this.wisdom = wisdom;
	}
	protected int getDefensePoints(){	//Retorna os pontos de defesa consideranto items e atributos
		double dp=0;
		double xp=0;
		for(int i = 0 ; i < this.getInventory().getNItems() ; i++){
			if (this.getInventory().searchItem(i).isEquiped() == true)	//Somente items equipados são somados
				dp += this.getInventory().searchItem(i).getDefensePts();
		}
		xp = (double)(this.XP/6);
		dp = ((this.constitution*.6 + this.dexterity*.1 + this.speed*.3) + dp)*xp;
		return (int)dp + (wisdom/2);
	}
	protected int getAttackPoints(){
		return 0;
	}
	public void attack(Character ch){
		double rand = Math.random(); 			//Chance realcionada as magias (de 0 a 0.9999999)
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
		double rand = Math.random(); 			//Chance realcionada as magias (de 0 a 0.9999999)
		if(rand < 0.25){
			if (cr.getElement() == Element.fire){
				return;
			}
			cr.addHP(-(this.FireStrike()));
			return;
		}
		if(rand < 0.50){
			if (cr.getElement() == Element.water){
				return;
			}
			cr.addHP(-(this.WaterStrike()));
			return;
		}
		if(rand < 0.75){
			if (cr.getElement() == Element.earth){
				return;
			}
			cr.addHP(-(this.EarthStrike()));
			return;
		}
		if (rand < 1){
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
		return (int)(wisdom*0.10 + XP/3);
	}	
	public int EarthStrike(){
		return (int)(wisdom*0.30 + XP/3);
	}
	public int WaterStrike(){
		return (int)(wisdom*0.50 + XP/3);
	}
	public int FireStrike(){
		return (int)(wisdom*0.70 + XP/3);
	}
	public void Healing(Individual individual){
		individual.addHP((int)(this.wisdom*0.3 + XP/4));
	}
	public void IntenseHealing(Individual individual){
		individual.addHP((int)(this.wisdom*0.4 + XP/4));
	}
}