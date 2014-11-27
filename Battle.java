public class Battle extends Thread{
	
	private Character character;
	private Creature against1, against2;

	public Battle(String str, Character character, Creature against1, Creature against2){
		super(str);
		this.character = character;
		this.against1 = against1;
		this.against2 = against2;
	}


	public void run(){
		
		int num_attacks = 0;

		while(against1.getHP() > 0){
			character.attack(against1);
			num_attacks++;
		}
		character.addXP(num_attacks * 2);

		num_attacks = 0;
		while(against2.getHP() > 0){
			character.attack(against2);
			num_attacks++;
		}
		character.addXP(num_attacks * 2);
	}
}