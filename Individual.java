/*
Classe base para todos os personagens do jogo (Characters e Creatures).
Implementa características presentes em todos os personagens, como MP, HP e nome,
além de seus getters.
*/

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
		if (this.HP + hp > 100)
			this.HP = 100;
		if (this.HP + hp < 0){
			this.HP = 0;
		}
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