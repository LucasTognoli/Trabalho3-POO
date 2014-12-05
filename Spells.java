/*
Classe interface que é implementada em characters que usam magias e 
por creatures que também as usam.
*/

interface Spells{
	int AirStrike();
	int EarthStrike();
	int WaterStrike();
	int FireStrike();
	void Healing(Individual individual);
	void IntenseHealing(Individual individual);
}