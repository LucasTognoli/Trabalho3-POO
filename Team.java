import java.util.ArrayList;
import Item.*;

public class Team{
	private String name;
	private Color color;
	private int win;
	private int lose;
	private int draw;
	
	private ArrayList<Character> characters;
	
	public Team(String name,Color color){	//Construtor
		this.name = name;
		this.color = color;
		this.characters = new ArrayList<Character>();
	}
	public String getName(){
		return this.name;
	}
	public String getResults(){	//Retorna uma string com os resultados do time
		String result = new String("Win:" + win + "	Lose:" + lose + "	Draw:" + draw);
		return result;		
	}
	public int getPoints(){	//Retorna os pontos do time (soma dos HPs dos characters)
		int points = 0;
		for(int i = 0 ; i < characters.size() ; i++){
			points += characters.get(i).getHP();
		}
		return points / characters.size()+1;
	}
	public void showTeam(){	//Mostra todos os characters dentro do time
		System.out.println("TEAM "+this.getName()+":");
		for(int i = 0 ; i < characters.size() ; i++){
			System.out.println(characters.get(i).getName());
		}
	}
	public String toString(){	//Retorna o nome e a cor do time
		String s = new String("Name:" + name + "Color:" + color);
		return s;
	}
	public void resolveBattle(Team teamb){	//Resolve a batalha apenas para o time que chamou o metodo. Baseando-se em getPoints()
		if (this.getPoints() > teamb.getPoints()){
			this.win ++;
			return;
		}
		if (this.getPoints() == teamb.getPoints()){
			this.draw ++;
			return;
		}
		else{
			this.lose ++;
		}
	
	}
	public void addChar(Character ch){	//Adiciona um character ao time
			characters.add(ch);
	}
	public void removeChar(int i){	//Remove um character do time pelo indice
		characters.remove(i);
	}
	public void removeChar(Character ch){	//Remove um character do time
		for (int i = 0 ; i < characters.size() ; i++){
			if(characters.get(i).equals(ch)){
				characters.remove(i);
				return;
			}
		}
	}
	public Character searchChar(String name){	//Procura um character pelo nome
		for (int i = 0 ; i < characters.size() ; i++){
			if(characters.get(i).getName().equals(name)){		
				return characters.get(i);
			}
		}
		return null;
	}
}