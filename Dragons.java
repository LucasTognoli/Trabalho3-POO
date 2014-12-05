/*
As criaturas do tipo Dragão são hybridas e portanto podem atacar tanto fisicamente como por Spells.
*/

public class Dragons extends Creature implements Spells{
	
	protected int power;
	protected int wisdom;

	public Dragons(String name,Element element){
		super(name);
		this.element = element;
	}

	public void addPower(int power){
		if (power < 0)
			return;
		this.power+=power;
	}
	public void addWisdom(int wisdom){
		if (wisdom < 0)
			return;
		this.wisdom+=wisdom;
	}
	protected int getDefensePoints(){
		return 200;
	}
	protected int getAttackPoints(){
		return 200;
	}
	public void attack (Character ch){
		if (this.element.getName() == "air"){
			ch.addHP(-(this.AirStrike()));
		}
		if (this.element.getName() == "earth"){
			ch.addHP(-(this.EarthStrike()));
		}
		if (this.element.getName() == "fire"){
			ch.addHP(-(this.FireStrike()));
		}
		if (this.element.getName() == "water"){
			ch.addHP(-(this.WaterStrike()));
		}
		if (this.element.getName() == "physical"){	//Ataque fisico
			ch.addHP(-(int)(power*0.5));	//Usando power para o calculo do ataque fisico.
		}
	}
	
	public int AirStrike(){
		return (int)(wisdom*0.10);
	}	
	public int EarthStrike(){
		return (int)(wisdom*0.30);
	}
	public int WaterStrike(){
		return (int)(wisdom*0.50);
	}
	public int FireStrike(){
		return (int)(wisdom*0.70);
	}
	public void Healing(Individual individual){
		return;
	}
	public void IntenseHealing(Individual individual){
		return;
	}
}