package game;

import players.Player;

//In sich abgeschlossenes Spiel von Tic-Tac-Toe mit Anzahl n {1..*} an Runden 
public class Match {
		
	int[] score = new int[2]; 	//Beinhaltet zwei Zahlenwerte mit den Punktständen für je einen Spieler
	int countRound;				//Zählt Anzahl der Spielrunden n mit n = {1..*}			
	Player[] playerList = new Player[2];	//Speichert, welcher Spieler Round1 anfängt; danach immer im Wechsel
	int matchType;			//0 für Mensch/Mensch; 1 für Mensch/Computer;  2 Computer/Computer
	int beginner;			//Gibt an, wer erste Runde anfängt; 1 = Spieler 1 und 2 = Spieler 2
	
/*
 * Konstruktor	
 */
	
	

	//DEFAULT Konstruktor - (für zwei menschliche Spieler)
	public Match() {
		this.score = new int[]{0,0};
		this.countRound = 0;
		this.playerList[0] = new players.Human();
		this.playerList[1] = new players.Human();
		this.matchType = 0;
		this.beginner = 1;
	}
	
	//für Mensch gegen Computer
	public Match(int matchType, int beginner) {
		this.score = new int[]{0,0};
		this.countRound = 0;
		this.beginner = beginner;
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
			if (beginner == 1) {
				this.playerList[0] = new players.Human();
				this.playerList[1] = new players.Computer();
			}
			else {
				this.playerList[1] = new players.Human();
				this.playerList[0] = new players.Computer();
			}
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
		return beginner;
	}

	public void setBeginner(int beginner) {
		this.beginner = beginner;
	}
	
	
/*
 *	Klassenmethoden 
 */
	
	

	public void resetMatch(int newMatchType) {
		if (newMatchType != this.matchType) {
			new Match(newMatchType, this.beginner);
		}
		this.countRound = 0;
		this.matchType = newMatchType;
	}

	public void printScore() {
		System.out.print("Spielstand: ");
		System.out.print(this.score[0] + " : ");
		System.out.print(this.score[1]);
	}
	
	public void refreshScore(int winner) {
		if (winner != 0) {
		this.setScore(winner-1, ( this.getScore(winner-1)+1 ) );
		}
	}
	
	
	
}
