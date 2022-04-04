package game;

import lejos.hardware.lcd.LCD;
import game.Match;
import players.Player;

public class Round {

	public Board board; // Jede Spielrunde besitzt ein Board
	int playerTurn; // gibt an, wer am Zug ist; 1 = "X"; 2 = "O"
	int countMoves = 0; // Zählt Anzahl der Spielzüge {0 bis 9}
	int beginnerRound = 0; // Gibt an, wer Runde beginnt; 1 für Spieler 1; 2 für Spieler 2
	boolean end; //
	static int countRound = 1;
	int winnerRound = 0;

	/*
	 * //Konstruktor
	 */
	public Round(Match match) {
		this.board = new Board();
		this.playerTurn = 1;
		this.countMoves = 0;
		this.end = false;
		if (countRound % 2 == 0) {
			this.beginnerRound = match.getBeginner();
		} else {
			this.beginnerRound = countRound % 2 + 1;
		}
	}

	public Round(Board b, int playerTurn, int cM, boolean end) {
		this.board = new Board();
		this.playerTurn = playerTurn;
		this.countMoves = 0;
		this.end = false;
	}

// Klassenmethoden	

	public void refreshIsEnd() {
		if (this.getCountMoves() == 9) {
			this.setEnd(true);
		}
		isEnd();
	}

	// Methode prüft, ob ein Spieler gewonnen hat und gibt Spieler als int zurück
	public boolean isWon() {
		// Zeilenweise waagrecht
		for (int j = 0; j <= 2; j++) {
			int i = 0;
			if (board.field[i][j].getFieldValue() == 1 && board.field[i + 1][j].getFieldValue() == 1
					&& board.field[i + 2][j].getFieldValue() == 1) {
				// match.refreshScore(1);
				setRoundWinner(1);
				return true;
			}
			if (board.field[i][j].getFieldValue() == 2 && board.field[i + 1][j].getFieldValue() == 2
					&& board.field[i + 2][j].getFieldValue() == 2) {
				// refreshScore(2);
				setRoundWinner(2);
				return true;
			}

		}

		// Spaltenweise senkrecht
		for (int i = 0; i <= 2; i++) {
			int j = 0;
			if (board.field[i][j].getFieldValue() == 1 && board.field[i][j + 1].getFieldValue() == 1
					&& board.field[i][j + 2].getFieldValue() == 1) {
				// refreshScore(1);
				setRoundWinner(1);
				return true;
			}

			if (board.field[i][j].getFieldValue() == 2 && board.field[i][j + 1].getFieldValue() == 2
					&& board.field[i][j + 2].getFieldValue() == 2) {
				// refreshScore(2);
				setRoundWinner(2);
				return true;
			}
		}

		// diagonal
		// oben links - Mitte - unten rechts
		if (board.field[0][0].getFieldValue() == 1 && board.field[1][1].getFieldValue() == 1
				&& board.field[2][2].getFieldValue() == 1) {
			setRoundWinner(1);

			return true;
		}
		if (board.field[0][0].getFieldValue() == 2 && board.field[1][1].getFieldValue() == 2
				&& board.field[2][2].getFieldValue() == 2) {
			setRoundWinner(2);

			return true;
		}
		// oben rechts - Mitte - unten links
		if (board.field[2][0].getFieldValue() == 1 && board.field[1][1].getFieldValue() == 1
				&& board.field[0][2].getFieldValue() == 1) {
			setRoundWinner(1);

			return true;
		}
		if (board.field[2][0].getFieldValue() == 2 && board.field[1][1].getFieldValue() == 2
				&& board.field[0][2].getFieldValue() == 2) {
			setRoundWinner(2);
			return true;
		}
		return false;
	}

	public void resetRound() {
		this.setCountRound(1);
	}

	// Spielerwechsel nach Zug
	public void changeTurn() {
		if (playerTurn == 1) {
			setPlayerTurn(2);
			// LCD.drawString("O is next!", 0, 0);
			System.out.println("O is next!");
			return;
		}
		if (playerTurn == 2) {
			setPlayerTurn(1);
			// LCD.drawString("X is next!", 0, 0);
			System.out.println("X is next!");
			return;
		}
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

	public static int getCountRound() {
		return countRound;
	}

	public static void setCountRound(int countRound) {
		Round.countRound = countRound;
	}

	public void setRoundWinner(int winner) {
		this.winnerRound = winner;
	}

	public int getRoundWinner() {
		return this.winnerRound;
	}

}
