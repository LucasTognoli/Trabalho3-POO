/*
Criaturas do tipo humanoides atacam fisicamente usando a variavel power.
*/

public class Humanoids extends Creature{
	
	protected int power;

	public Humanoids(String name,Element element){
		super(name);
		this.element = Element.physical;
	}
	public void addPower(int power){
		if (power < 0)
			return;
		this.power+=power;
	}
	protected int getDefensePoints(){
		return 100;
	}
	protected int getAttackPoints(){
		return 100;
	}
	public void attack (Character ch){
		ch.addHP(-(int)(power*0.80));
	}
}