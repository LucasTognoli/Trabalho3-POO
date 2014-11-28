import Item.*;

public class Paladin extends Character{
	protected int power;

	public Paladin(String name,int power){
		super(name);
		this.power = power;
	}
	protected int getDefensePoints(){	//Retorna os pontos de defesa do character considerando items e atributos
		double dp=0;
		double xp=0;
		for(int i = 0 ; i < this.getInventory().getNItems() ; i++){
			Item aux = this.getInventory().searchItem(i);
			if ( this.getInventory().isEquiped(aux) == true)	//Somente items equipados sao considerados
				dp += this.getInventory().searchItem(i).getDefensePts();
		}
		xp = (double)(this.XP/6);
		dp = ((this.constitution*.6 + this.dexterity*.1 + this.speed*.3) + dp)*xp;
		return (int)dp;
	}
	protected int getAttackPoints(){	//Retorna os pontos de defesa do character considerando items e atributos
		double ap=0;
		double xp=0;
		for(int i = 0 ; i < this.getInventory().getNItems() ; i++){
			Item aux = this.getInventory().searchItem(i);
			if ( this.getInventory().isEquiped(aux) == true)	//Somente items equipados sao considerados
				ap += this.getInventory().searchItem(i).getAttackPts();
		}
		xp = (double)(this.XP/2);
		ap = ((this.strenght*.6 + this.dexterity*.4) + ap)*xp;	
		return (int)ap + power;
	}
	public void attack(Character ch){
		double rand = Math.random(); 			//Missing Chance (de 0 a 0.9999999)
		int dmg = (int)(Math.random()*11 - 5); 		//Variavel para calcular dano (de -5 a 5)

		if (rand < (0.1)/this.XP ){ 			//Miss.
			//System.out.println("Attack Miss. Damage = 0");
			return;
		}



		if (dmg <= 0){
			dmg = (int)(this.getAttackPoints() - ch.getDefensePoints()) + 1;
			if (dmg < 0) dmg = 0;
		}
		else{ 
			dmg = (int)(this.getAttackPoints() - ch.getDefensePoints()) + dmg;
			if (dmg < 0) dmg = 0;
		}



		if (rand < (0.02)*(this.XP/2) ){			//Critico.
			ch.addHP(-(dmg*2));
			//System.out.println("Attack Critico. Damage = " + 2*dmg);			
			return;
		}
		else{						//Atk Normal.
			ch.addHP(-dmg);			
			//System.out.println("Attack Normal. Damage = " + dmg);
			return;
		}
	}
public void attack(Creature cr){
		cr.addHP(-(int)((this.power)*0.90));
	}

	public void addPower(int power){
		this.power += power;
	}
}