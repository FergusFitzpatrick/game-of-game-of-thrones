/*
* Author Fergus Fitzpatrick
*
* Date 7-11-16
*
* This is not near finished.
* And is written poorly so far.
*/
public class charAttributes{
	private String warriorNames;
	private int power;
	private double speed;
	public int health;
	public double damageDone;
	public double damageDealt;
	public double stamina;
	public boolean alive;
	public int skill;


	public charAttributes( String warriorNames, int skill, int power, double speed, int health, double damageDone, double damageDealt, double stamina, boolean alive){
		this.warriorNames = warriorNames;
		this.skill = skill;
		this.power = power;
		this.speed = speed;
		this.health = health;
		this.damageDone = damageDone;
		this.damageDealt = damageDealt;
		this.stamina = stamina;
		this.alive = alive;

	}

	public void getPlayerDetails(){
		System.out.println("\n\tHealth: " + health +
				"\n\tPower: " + power +
				"\n\tSpeed: " + speed);
	}
}
