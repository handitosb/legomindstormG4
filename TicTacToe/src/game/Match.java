package game;

import players.Player;
import game.Round;

//In sich abgeschlossenes Spiel von Tic-Tac-Toe mit Anzahl n {1..*} an Runden 
public class Match {
		
	static int[] score = new int[2]; 	//Beinhaltet zwei Zahlenwerte mit den Punktst�nden f�r je einen Spieler
	int countRound;				//Z�hlt Anzahl der Spielrunden n mit n = {1..*}			
	Player[] playerList = new Player[2];	//Speichert die beiden Spieler
	int matchType;			//0 f�r Mensch/Mensch; 1 f�r Mensch/Computer;  2 Computer/Computer
	int matchBeginner;			//Gibt an, wer erste Match beginnt; 1 = Spieler 1 und 2 = Spieler 2
	
/*
 * Konstruktor	
 */
	
	

	//DEFAULT Konstruktor - (f�r zwei menschliche Spieler)
	public Match() {
		this.score = new int[]{0,0};
		this.countRound = 1;
		setPlayerList(0, 1);
		this.matchType = 0;
		this.matchBeginner = 1;
	}
	
	//f�r Mensch gegen Computer
	public Match(int matchType, int beginner) {
		this.score = new int[]{0,0};
		this.countRound = 1;
		this.matchBeginner = beginner;
		setPlayerList(matchType, beginner);
		
	 }
	
	
	
/*
 * 	Getter- und Setter-Methoden
 */
	
	public int getScore(int n) {
		return this.score[n];
	}

	//Sobald Round gewonnen oder Draw, wird Spielstand aktualisiert
	public void setScore(int n, int newScore) {
		this.score[n] = newScore;
	}
	
	public void setPlayerList(int matchType, int beginner) {
		if (matchType == 0) {
			this.playerList[0] = new players.Human();				
			this.playerList[1] = new players.Human();
		}
		if (matchType == 1) {
				this.playerList[0] = new players.Human();
				this.playerList[1] = new players.Computer();
			
			
		}
		if (matchType == 2) {
			this.playerList[0] = new players.Computer();
			this.playerList[1] = new players.Computer();
		} 
	}
	
	

	
	//Gibt Anzahl an gespielten Runden.
	public int getCountRound() {
		return countRound;
	}

	public void setCountRound(int countRound) {
		this.countRound = countRound;
	}
	
	public int getBeginner() {
		return matchBeginner;
	}

	public void setBeginner(int beginner) {
		this.matchBeginner = beginner;
	}
	
	
/*
 *	Klassenmethoden 
 */
	
	

	public void resetMatch(int newMatchType) {
		if (newMatchType != this.matchType) {
			new Match(newMatchType, this.matchBeginner);
		}
		this.countRound = 0;
		this.matchType = newMatchType;
	}

	public static void printScore() {
		System.out.print("Spielstand: ");
		System.out.print(score[0] + " : ");
		System.out.print(score[1]);
	}
	
	public void refreshScore(Round round) {
		if (round.getRoundWinner() != 0) {
		this.setScore(round.getRoundWinner()-1, ( this.getScore(round.getRoundWinner()-1)+1 ) );
		}
	}
	
	
	
}
