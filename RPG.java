import Item.*;

public class RPG{
	public static void main (String[]args){

//************** INSTANCIANDO OS OBJETOS *********************************//
	
		Paladin ch0 = new Paladin("ch0",5);
		Knight ch1 = new Knight("ch1",5);
		Paladin ch2 = new Paladin("ch2",5);
		Paladin ch3 = new Paladin("ch3",5);
		Druid ch4 = new Druid("ch4",5);
		Sorcerer ch5 = new Sorcerer("ch5",5);
		Sorcerer ch6 = new Sorcerer("ch6",5);
		Paladin ch7 = new Paladin("ch7",5);

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


		Team t0 = new Team("Alfa",Color.red);
		Team t1 = new Team("Beta",Color.blue);

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


//************** RODADE DE ATTACKS E RESOLVEBATTLE **************************//


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

		//System.out.println(t0.getResults());
		//System.out.println(t1.getResults());

	}

}
