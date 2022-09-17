package game;

import lejos.hardware.lcd.LCD;
import game.Match;

public class Round {

	public Board board; // Jede Spielrunde besitzt ein Board
	int playerTurn; // gibt an, wer am Zug ist; 1 = "X"; 2 = "O"
	int countMoves = 0; // Zählt Anzahl der Spielzüge {0 bis 9}
	boolean end; //

	/*
	 * //Konstruktor
	 */
	public Round() {
		this.board = new Board();
		this.playerTurn = 1;
		this.countMoves = 0;
		this.end = false;
	}

	public Round(Board b, int playerTurn, int cM, boolean end) {
		this.board = new Board();
		this.playerTurn = playerTurn;
		this.countMoves = 0;
		this.end = false;
	}

// Klassenmethoden	

	public void refreshIsEnd() {
		if (this.getCountMoves() == 9 ) {
			this.setEnd(true);
		}
		isEnd();
	}
	
	// Methode prüft, ob ein Spieler gewonnen hat und gibt Spieler als int zurück
	public int isWon() {
		// Zeilenweise waagrecht
		for (int j = 0; j <= 2; j++) {
			int i = 0;
			if (board.field[i][j].getFieldValue() == 1 && board.field[i+1][j].getFieldValue() == 1
						&& board.field[i+2][j].getFieldValue() == 1) {
				//match.refreshScore(1);
				return 1;
			}
			if (board.field[i][j].getFieldValue() == 2 && board.field[i+1][j].getFieldValue() == 2
					&& board.field[i+2][j].getFieldValue() == 2) {
				//refreshScore(2);
				return 2;
			}
				
			}
		
		// Spaltenweise senkrecht
		for (int i = 0; i <= 2; i++) {
			int j = 0;
				if (board.field[i][j].getFieldValue() == 1 && board.field[i][j+1].getFieldValue() == 1
						&& board.field[i][j+2].getFieldValue() == 1) {
					//refreshScore(1);
					return 1;
				}
					
				if (board.field[i][j].getFieldValue() == 2 && board.field[i][j+1].getFieldValue() == 2
						&& board.field[i][j+2].getFieldValue() == 2) {
					//refreshScore(2);
					return 2;
				}
			}
		
		// diagonal
		// oben links - Mitte - unten rechts
		if (board.field[0][0].getFieldValue() == 1 && board.field[1][1].getFieldValue() == 1
				&& board.field[2][2].getFieldValue() == 1) 
			return 1;
		if (board.field[0][0].getFieldValue() == 2 && board.field[1][1].getFieldValue() == 2
				&& board.field[2][2].getFieldValue() == 2)
			return 2;
		// oben rechts - Mitte - unten links
		if (board.field[2][0].getFieldValue() == 1 && board.field[1][1].getFieldValue() == 1
				&& board.field[0][2].getFieldValue() == 1)
			return 1;
		if (board.field[2][0].getFieldValue() == 2 && board.field[1][1].getFieldValue() == 2
				&& board.field[0][2].getFieldValue() == 2)
			return 2;
		
			return 0;
	}
	
	
	

	/*
	 * Getter- und Setter-Methoden
	 */

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}

	public int getCountMoves() {
		return countMoves;
	}

	public void setCountMoves(int countMoves) {
		this.countMoves = countMoves;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	/*
	 * Klassenmethoden
	 */

	// Spielerwechsel nach Zug
	public void changeTurn() {
		if (playerTurn == 1) {
			setPlayerTurn(2);
			//LCD.drawString("O is next!", 0, 0);
			System.out.println("O is next!");
			return;
		}
		if (playerTurn == 2) {
			 setPlayerTurn(1);
			 //LCD.drawString("X is next!", 0, 0);
			 System.out.println("X is next!");
			 return;
		}
	}

}
