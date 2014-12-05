/*
Uma Creature herda as características de Individual, como todo prsonagem. No entanto,
ela foi criada apenas para ser atacada por Character e aumentar seu XP. Essa classe abstrata
apenas oferece suporte a suas classes filhas, que realmente implementas as diferentes características
de diferentes criaturas.
*/

public abstract class Creature extends Individual{
	
	protected Element element;

	
	public Creature (String name){
		super(name);
	}
	public Element getElement(){
		return this.element;
	}
	public String getName(){
		return this.element.getName() +" "+ name;
	}
}