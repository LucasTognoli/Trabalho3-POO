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