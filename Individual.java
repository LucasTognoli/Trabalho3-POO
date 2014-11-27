public abstract class Individual{

	protected String name;
	protected int HP;
	protected int MP;

	public Individual(String name){
		this.name = name;
		this.HP = 100;
		this.MP = 100;
	}
	public void addHP(int hp){
		if (this.HP + hp > 1000)
			this.HP = 1000;
		else
			this.HP += hp; 

	}
	public void addMP(int mp){
		this.MP += mp;
	}
	public int getHP(){
		return this.HP;
	}
	public int getMP(){
		return this.MP;
	}
	public String getName(){
		return this.name;
	}	
	protected abstract int getDefensePoints();
	protected abstract int getAttackPoints();
	public abstract void attack(Character ch);
}