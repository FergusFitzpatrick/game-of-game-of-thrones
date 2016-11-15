/*
* Author Fergus Fitzpatrick
*
* Date 7-11-16
*
* This is not near finished.
* And is written poorly so far.
*/
import java.util.*;

public class GOGOT{
	public static void main (String args[]){

		//game variables and scanner initialising
		Scanner scan  = new Scanner (System.in);
		String player = "";
		int playerNum = 0;
		boolean choosing = true;
		boolean running = true;
		int power =0;
		double speed=0;
		int health=0;
		int skill=0;
		String opponentName;

		System.out.println("\n\t* Welcome to the Game Of Game Of Thrones! *");
		System.out.println("\t\t* Please choose your WARRIOR! *");
		System.out.println();

		String[] warriorNames = {"Dharius", "Brien Of Tarth","Jon Snow","Jaime Lanaster","The NightKing"};

		for(int i = 0, j=1; i < warriorNames.length ;i++){
			System.out.println("\t"+j+" >" +warriorNames[i]);
			j++;
		}

		LOOPONE:
		while(choosing){
			System.out.println();
			int input = scan.nextInt();

			if( input > 5 | input < 1){
				System.out.println("Invalid Input");
				continue LOOPONE;
			}
			for (int i = 0, j = 1; i < warriorNames.length; i++){
				if( input == j){
					player = warriorNames[i];
					choosing = false;
					break;
				}
				j++;
			}
		}

		if ( player.equals("Dharius")){
			power = 90;
			speed = 93.0;
			health = 100;
			skill = 92;
		}
		else if (player.equals("Brien Of Tarth")){
			power  = 93;
			speed = 87.5;
			health = 100;
			skill = 89;
		}
		else if (player.equals("Jon Snow")){
			power = 90;
			speed = 92.5;
			health = 110;
			skill = 91;
		}
		else if (player.equals("Jaime Lanaster")){
			power = 89;
			speed = 90.5;
			health = 100;
			skill = 93;
		}
		else if (player.equals("The NightKing")){
			power = 98;
			speed = 85;
			health = 120;
			skill = 76;
		}
		opponentName = opponentNameMaker();

		charAttributes Player1  = new charAttributes(player, skill, power, speed, health, 0.0, 0.0, 100.0, true);
		charAttributes opponent = new charAttributes(opponentName, skill, power, speed, health, 0.0, 0.0, 100.0, true);

		System.out.println("\n\tYou have chosen: "+ player +" !");

		Player1.getPlayerDetails();
		System.out.println();
		System.out.println("Are you ready to enter the battlefield?");
		scan.nextLine();
		String input1 = scan.nextLine();


		if (input1.equalsIgnoreCase("no")) {
			System.out.println("You're not ready.");
		}
		else{
				System.out.println("You better be! Look out! Wildlings are heading your way!");
		}

		System.out.println(opponentName +" is your opponent! Fight To The Death!");

		while( Player1.alive == true){
				System.out.println("Your Move: \n\t1. Strong Attack \n\t2. Fast Attack \n\t3. Dodge");
				int input = scan.nextInt();
				Attack(input, scan, Player1);
				opponentMove(opponent, Player1);
				break;
		}
	}
	public static String opponentNameMaker(){
			String[] opponentnames = {"Ygritte","Lord Of Bones","Giant"};
			String result = "";
			for (int i =0; i < opponentnames.length ; i++){
				result =  opponentnames[i];
				break;
			}
			return result;
	}

	//Need better points system. try multiply current system by 10 and get rid of decimal points.
	public static double Attack(int input, Scanner scan, charAttributes Player1){
		String move = "";
		if ( input == 1 ){
			Player1.damageDealt = ((Player1.speed/2) * (Player1.power) + (Player1.stamina * Player1.skill))/ (Player1.stamina*Player1.health);
			move = "Strenght Attack";
		}
		else if ( input  == 2){
			Player1.damageDealt = (Player1.speed * (Player1.power / 2) + (Player1.stamina * Player1.skill))/ (Player1.stamina*Player1.health);
			move = "Speed Attack";
		}
		else if (input == 3){
			Player1.damageDealt = 0;
			Player1.damageDone = 0;
			move = "Dodge";
		}
		else{
			System.out.println("Invalid input");
			input = scan.nextInt();
			Attack(input, scan, Player1);
		}
		System.out.println("You chose to: "+ move+" - "+Player1.damageDealt+" HitPoints!");
		return Player1.damageDealt;
	}

	//Need a better method for calling a random number between 1,2,3
	public static double opponentMove(charAttributes opponent, charAttributes Player1){
		double moveNumber = Math.random() * 3 + 1;
		String move = "";
		if ( moveNumber == 1.0 ){
				opponent.damageDealt = ((opponent.speed/2) * (opponent.power) + (opponent.stamina * opponent.skill)) / (opponent.stamina * opponent.health);
				move = "Strenght Attack";
		}
		else if( moveNumber == 2.0 ){
			opponent.damageDealt = (opponent.speed * (opponent.power /2) + (opponent.stamina * opponent.skill)) / (opponent.stamina * opponent.health);
			move = "Speed Attack";
		}
		else if( moveNumber == 3.0 ){
			opponent.damageDealt = 0;
			opponent.damageDone = 0;
			move = "Dodge";
		}
		System.out.println(opponent.warriorNames+" chose to: "+ move+" = "+opponent.damageDealt+" HitPoints!");
		return opponent.damageDealt;
	}
}
