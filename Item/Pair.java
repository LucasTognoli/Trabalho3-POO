/*
Aqui é feito a programação genérica exigida no trabalho. A classe pair é usada no ArrayList
dentro de inventario para criar um array de Items e de Bool.
Dentro da classe Pair os metodos e os atributos são genéricos e portanto aceitam instancias de qualquer 
tipo de variável. Somente na classe Inventory que o T e o B são definidos como Item e Bool.
*/

package Item;

public class Pair <T,B> {

   	private T item;
   	private B bool;

	public Pair() { 
		item = null; 
   		bool = null; 
   	}
   	public Pair(T item, B bool) { 
   		this.item = item;  
   		this.bool = bool; 
   	}

   	public T getItem() { 
   		return item; 
  	}
  	 public B getBool() { 
   		return bool; 
  	}

   	public void setItem(T item) { 
   		this.item = item; 
   	}
   	public void setBool(B bool) { 
   		this.bool = bool; 
   	}
}