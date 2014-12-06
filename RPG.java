/*
Classe principal do jogo, que tem o papel de instanciar todos os personagens, criaturas ítens que
serão utilizados.
- O jogo será composto por 2 times de 4 personagens cada;
- Serão criadas algumas criaturas, que são usadas no processo de "XP increasing" de cada Character;
- O "XP increasing" consiste em cada Character atacar duas criaturas até matá-las, ganhando XP proporcional
ao número de ataques que levou para matar;
- Cada Character roda seu "XP Increasing" de forma concorrente aos outros Characters, ou seja, todo o processo
é feito por meio de Threads;
- Depois de aumentar o XP, os personagens realizam batalhas, exatamente como feito no Trabalho 2.
*/


import Item.*;

public class RPG{
	public static void main (String[]args){

//************** INSTANCIANDO OS OBJETOS *********************************//
		// Characters
		Paladin ch0 = new Paladin("Paladino1",5);
		Knight ch1 = new Knight("Cavaleiro1",5);
		Paladin ch2 = new Paladin("Paladino2",5);
		Paladin ch3 = new Paladin("Paladino3",5);
		Druid ch4 = new Druid("Druida",20);
		Sorcerer ch5 = new Sorcerer("Feiticeiro1",13);
		Sorcerer ch6 = new Sorcerer("Feiticeiro2",13);
		Paladin ch7 = new Paladin("Paladino4",5);

		// Creatures
		Dragons cr0 = new Dragons("Frost Dragon",Element.water);
		Dragons cr1 = new Dragons("Dragon Lord",Element.fire);
		Dragons cr2 = new Dragons("Undead Dragon",Element.physical);
		Demons cr3 = new Demons("Demon",Element.fire);
		Demons cr4 = new Demons("Juggernaut",Element.earth);
		Demons cr5 = new Demons("Diabolic Imp",Element.fire);
		Witchs cr6 = new Witchs("Infernalist",Element.fire);
		Witchs cr7 = new Witchs("Warlock",Element.air);
		Humanoids cr8 = new Humanoids("Assassin",Element.physical);
		Humanoids cr9 = new Humanoids("Hero",Element.physical);
		Demons cr10 = new Demons("Hakuna",Element.earth);
		Demons cr11 = new Demons("Matata",Element.fire);
		Witchs cr12 = new Witchs("Ehlindo",Element.fire);
		Witchs cr13 = new Witchs("Dizer",Element.air);
		Humanoids cr14 = new Humanoids("Voce",Element.physical);
		Humanoids cr15 = new Humanoids("Vai",Element.physical);

		//Teams
		Team t0 = new Team("Alfa",Color.red);
		Team t1 = new Team("Beta",Color.blue);

		//Items
		Item itemA0 = new Armor("Magic Plate Armor",99.9,25,20);
		Item itemA1 = new Armor("Demon Armor",99.9,25,20);
		Item itemA2 = new Armor("Dragon Scale Mail",99.9,25,20);
		Item itemA3 = new Armor("Blessed Shield",99.9,25,20);
		Item itemA4 = new Armor("Great Shield",99.9,25,20);
		Item itemA5 = new Armor("Demon Helmet",99.9,25,20);

		Item itemW0 = new Weapon("Warlord Sword",99.9,40,10);
		Item itemW1 = new Weapon("Hellforged Axe",99.9,40,10);
		Item itemW2 = new Weapon("Solar Axe",99.9,40,10);
		Item itemW3 = new Weapon("Skullcrusher",99.9,40,10);
		Item itemW4 = new Weapon("Hammer of Prophecy",99.9,40,10);
		Item itemW5 = new Weapon("Royal Crossbow",99.9,40,10);
		Item itemW6 = new Weapon("Mycological Bow",99.9,40,10);
		Item itemW7 = new Weapon("Royal Spear",99.9,40,10);
		Item itemW8 = new Weapon("Wand of Inferno",99.9,40,10);
		Item itemW9 = new Weapon("Underworld Rodl",99.9,40,10);

		Item itemHP0 = new HealthPotion("Small HealthPotion",10.99,20);
		Item itemHP1 = new HealthPotion("Small HealthPotion",10.99,20);
		Item itemHP2 = new HealthPotion("Small HealthPotion",10.99,20);
		Item itemHP3 = new HealthPotion("Small HealthPotion",10.99,20);
		Item itemHP4 = new HealthPotion("Small HealthPotion",10.99,20);

		Item itemMP0 = new ManaPotion("Small ManaPotion",10.99,10);
		Item itemMP1 = new ManaPotion("Small ManaPotion",10.99,10);
		Item itemMP2 = new ManaPotion("Small ManaPotion",10.99,10);


//************** ATRIBUINDO OS ITEMS E EQUIPANDO ***********************//
	
		ch0.getInventory().insertItem(itemA0);
		ch0.getInventory().equipItem(itemA0);
	
		ch0.getInventory().insertItem(itemW0);
		ch0.getInventory().equipItem(itemW0);

		ch1.getInventory().insertItem(itemA1);
		ch0.getInventory().equipItem(itemA1);
		ch1.getInventory().insertItem(itemW1);
		ch0.getInventory().equipItem(itemW1);

		ch2.getInventory().insertItem(itemA2);
		ch0.getInventory().equipItem(itemA2);
		ch2.getInventory().insertItem(itemW2);
		ch0.getInventory().equipItem(itemW2);

		ch3.getInventory().insertItem(itemA3);
		ch0.getInventory().equipItem(itemA3);
		ch3.getInventory().insertItem(itemW3);
		ch0.getInventory().equipItem(itemW3);

		ch4.getInventory().insertItem(itemA4);
		ch0.getInventory().equipItem(itemA4);
		ch4.getInventory().insertItem(itemW4);
		ch0.getInventory().equipItem(itemW4);

		ch5.getInventory().insertItem(itemA5);
		ch0.getInventory().equipItem(itemA5);
		ch5.getInventory().insertItem(itemW5);
		ch0.getInventory().equipItem(itemW5);

		ch6.getInventory().insertItem(itemW6);
		ch0.getInventory().equipItem(itemW6);

		ch7.getInventory().insertItem(itemW7);
		ch0.getInventory().equipItem(itemW7);
		ch7.getInventory().insertItem(itemHP0);



		t0.addChar(ch0);
		t0.addChar(ch1);
		t0.addChar(ch2);
		t0.addChar(ch3);

		t1.addChar(ch4);
		t1.addChar(ch5);
		t1.addChar(ch6);
		t1.addChar(ch7);	

//************** RODADA EM QUE OS CHARACTERS MATAM CRIATURAR PARA UPAR ***************//

		Battle b1 = new Battle("Thread1", ch0, cr0, cr1);
		Battle b2 = new Battle("Thread2", ch1, cr2, cr3);
		Battle b3 = new Battle("Thread3", ch2, cr4, cr5);
		Battle b4 = new Battle("Thread4", ch3, cr6, cr7);
		Battle b5 = new Battle("Thread5", ch4, cr8, cr9);
		Battle b6 = new Battle("Thread6", ch5, cr10, cr11);
		Battle b7 = new Battle("Thread7", ch6, cr12, cr13);
		Battle b8 = new Battle("Thread8", ch7, cr14, cr15);

		b1.setPriority(Thread.NORM_PRIORITY);
		b2.setPriority(Thread.NORM_PRIORITY);
		b3.setPriority(Thread.NORM_PRIORITY);
		b4.setPriority(Thread.NORM_PRIORITY);
		b5.setPriority(Thread.NORM_PRIORITY);
		b6.setPriority(Thread.NORM_PRIORITY);
		b7.setPriority(Thread.NORM_PRIORITY);
		b8.setPriority(Thread.NORM_PRIORITY);

		//inicia as Threads
		b1.start();
		b2.start();
		b3.start();
		b4.start();
		b5.start();
		b6.start();
		b7.start();
		b8.start();
		
	/*  Bloco Try-Catch que controla o processo de join, que força o programa a esperar
		o termino de cada Thread para continuar.
	*/
		try {
			b1.join();
			b2.join();
			b3.join();
			b4.join();
			b5.join();
			b6.join();
			b7.join();
			b8.join();
		}
		catch(InterruptedException e) {}


		


//************** RODADA DE ATTACKS E RESOLVEBATTLE **************************//


		ch0.attack(ch4);

		ch1.attack(ch5);
		ch2.attack(ch6);
		ch3.attack(ch7);

		ch4.attack(ch0);
		ch5.attack(ch1);
		ch6.attack(ch2);
		ch7.attack(ch3);

		t0.resolveBattle(t1);
		t1.resolveBattle(t0);

		System.out.println("\n\nProcessando rodada de batalhas...");

		System.out.println("\n\nPlacar ao fim de uma batalha - Time1: " + t0.getResults());
		System.out.println("Placar ao fim de uma batalha - Time2: " + t1.getResults());

	}

}
