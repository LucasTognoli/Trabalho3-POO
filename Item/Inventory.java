package Item;
import java.util.ArrayList;

public class Inventory{

	private int spaces;
	private double gold;
	private ArrayList<Pair<Item,Boolean>> pair;


//*************** CONSTRUTOR ********************************************//
	public Inventory(){
		this.spaces = 10;
		this.gold = 0;
		//Pair<Item, Boolean> pair = new Pair<Item, Boolean>();
		this.pair = new ArrayList<Pair<Item,Boolean>>();
	}

//*************** METODOS GETTERS **************************************//
	public double getTotalGold(){
		return this.gold;
	}
	public int getAvailableSpace(){
		return this.spaces - this.pair.size();
	}
	public int getNItems(){	//Retorna o numero de items no personagem
		return this.pair.size();
	}

//************** METODOS COMPLEMENTARES *********************************//
	public void spendGold(double gold){
		if ((this.gold -= gold) < 0){	//Evita gastar dinheiro que nao existe
			System.out.println("ERRO:Dinheiro insuficiente");
			return;
		}
		this.gold -= gold;
	}
	public void earnGold(double gold){
		this.gold += gold;
	}
	public Item searchItem(String name){	//Procura pelo item no inventario pelo noem
		for (int i = 0 ; i < pair.size() ; i++){		
			if(pair.get(i).getItem().getName().equals(name)){
				return pair.get(i).getItem();
			}
		}
		System.out.println("ERRO:Item nao encontrado no inventario");
		return null;
	}
	public Item searchItem(int i){	//Procura pelo item no inventario pelo indice
		return pair.get(i).getItem();		
	}
	public Item searchItem(Item item){	//Procura o item no inventario
		for(int i = 0 ; i < pair.size() ; i++){
			if(pair.get(i).getItem().equals(item)){
				return pair.get(i).getItem();
			}
		}
		return null;

	}
	public void insertItem(Item item){	//Adiciona um item ao inventario	
		Pair<Item,Boolean> aux = new Pair<Item,Boolean>(item,false);
		pair.add(aux);
	}
	public void equipItem(Item item){	
		for(int i = 0 ; i < pair.size() ; i++){
			if(pair.get(i).getItem().equals(item)){
				pair.get(i).setBool(true);
				return;
			}
		}
		return;
	}
	public void removeItem(String name){	//Retira um item do inventario a partir do nome
		for (int i = 0 ; i < pair.size() ; i++){
			if(pair.get(i).getItem().getName().equals(name)){
				pair.remove(i);
				return;
			}
		}
		System.out.println("ERRO:Item não esta no inventario para ser removido");
	}
	public void removeItem(Item item){ //Retira um item do inventario
		for(int i = 0 ; i < pair.size() ; i++){
			if(pair.get(i).getItem().equals(item)){
				pair.remove(i);
				return;
			}
		}
		return;
	}
	public void removeItem(int i){	//Retira um item do inventario pelo indice
		pair.remove(i);
	}

//*************** METODOS SETTERS ***************************************//
	public void setSpaces(int spaces){
		if (spaces < 0 ){
			System.out.println("ERRO:Espaços negativos.Setado para 0");
			this.spaces = 0;
			return;	
		}
		if (spaces < pair.size()){
			System.out.println("ERRO:Numero de items impossibilita o novo numero de espaços");
			return;
		}	
		this.spaces = spaces;
	}

//***********************************************************************//


}
