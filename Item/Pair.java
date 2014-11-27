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