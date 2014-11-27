public class Battle extends Thread{
	
	private Team teamA, teamB;
	private Territory territory;
	public Counter count1, count2, count3; //contadores de vitórias do TeamA, TeamB e de empates
	
	// Tentar receber apenas cópias, para evitar que os Teams sejam mudados.
	public Battle(String str, Team teamA, Team teamB, Counter count1, Counter count2, Counter count3){
		super(str);
		this.teamA = teamA;
		this.teamB = teamB;
		this.count1 = count1;
		this.count2 = count2;
		this.count3 = count3;
	}


	public void run(){
		
		ch0.attack(ch4);
		ch1.attack(ch5);
		ch2.attack(ch6);
		ch3.attack(ch7);
		ch4.attack(ch0);
		ch5.attack(ch1);
		ch6.attack(ch2);
		ch7.attack(ch3);


		if(t0.resolveBattle(t1) == 1) {count1.sum(1);} //TeamA ganhou
			
		if(t0.resolveBattle(t1) == 0) {count3.sum(1);} //empatou
		
		if(t0.resolveBattle(t1) == -1) {count2.sum(1);} //TeamB ganhou
	}
}