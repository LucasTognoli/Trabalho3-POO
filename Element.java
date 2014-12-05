/*
Enumeração usada em Spells. Cada criatura mágica é composta por um elemento, e lança ataques
relacionados a ele.
*/

public enum Element {
	
	air("Air"),
	earth("Earth"),
	fire("Fire"),
	water("Water"),
	physical("Physical");


	public String nameElement;

	Element (String nameElement){
		this.nameElement = nameElement;
	}

	public String getName(){
		return nameElement;
	}
}