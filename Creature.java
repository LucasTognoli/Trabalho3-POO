

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