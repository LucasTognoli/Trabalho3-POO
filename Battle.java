/*
Classe que implementa a Thread de "XP increasing". Recebe como parâmetros uma String (nome da Thread),
um Character e duas Creaures.
Na execução da thread, o personagem ataca cada criatura até matá-la. Então, seu XP é aumentado
proporcionalmente (numero de ataques * 2) ao número de ataques necessários.
*/

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
		System.out.println(character.getName() + " ganhou " + (num_attacks *2) + " de XP!");

		num_attacks = 0;
		while(against2.getHP() > 0){
			character.attack(against2);
			num_attacks++;
		}
		character.addXP(num_attacks * 2);
		System.out.println(character.getName() + " ganhou " + (num_attacks *2) + " de XP!");
		System.out.println("FIM DE UMA THREAD");
	}
}