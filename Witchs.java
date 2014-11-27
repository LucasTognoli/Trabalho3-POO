public class Witchs extends Creature implements Spells{
	
	protected int wisdom;

	public Witchs(String name,Element element){
		super(name);
		this.element = element;
	}
	public void addWisdom(int wisdom){
		if (wisdom < 0)
			return;
		this.wisdom+=wisdom;
	}
	protected int getDefensePoints(){
		return 100;
	}
	protected int getAttackPoints(){
		return 100;
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
		if (this.element.getName() == "physical"){
			ch.addHP(-1);
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