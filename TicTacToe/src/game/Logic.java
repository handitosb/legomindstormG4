package game;

import basics.*;
import controls.*;
import lejos.hardware.*;
import lejos.hardware.lcd.*;
import lejos.utility.Delay;
import lejos.hardware.Button;
import players.Computer;
import players.Player;
import game.Round;
import game.Match;
import java.util.Random;
import java.util.Scanner;

public class Logic {
	
	static Scanner sc = new Scanner(System.in);
	static int ButtonID;
	
	public static void main(String args[]) {
		init();
		System.out.println("retry?");
		
		String anfrage = sc.next();
		
		String hint = "Invalid input please input y/n";
		String ans = "y";
		String no = "n";
        
		
		if (anfrage.equals("y")) {
			main(args);
		}
		if (anfrage.equals("n")) {
			System.out.println("Goodbye!  ");
		}
		else {
			System.out.println("invalid. Try y/n");
		}
		
		
//		showmainmenu();
//		Delay.msDelay(3000);
//		Display.clear();
//		Display.drawString("Push Button");
//		ButtonID = Button.waitForAnyEvent(ButtonID);
//		//System.out.println("buttonID "+ ButtonID);
//		Display.drawString(Integer.toString(ButtonID));
//		Delay.msDelay(1000);
		//System.out.println("Gewonnen");
	}

	private static void init() {
		
		
		// Roboter robot = new Roboter();
		// Display display = new Display();
		// Match match = new Match();
		Match match = new Match(2,2);
		Round round = new Round(match);
		Computer computer1 = new Computer();
		Computer computer2 = new Computer();
		
		matchType2(match, round);
		

//Test f�r setBoard(); match.refreshScore(); board.resetBoard()		
//		match.printScore();
//		round.board.setBoard(0, 2, 1);
//		round.board.setBoard(0, 2, 2);
//		round.board.setBoard(0, 0, 1);
//		round.board.printBoardConsole();
//		System.out.println(Integer.toString(round.isWon()));
//		match.refreshScore(round.isWon());
//		match.printScore();
//		
//		round.board.resetBoard();
//		round.board.printBoardConsole();
//		round.board.setBoard(0, 2, 2);
//		round.board.setBoard(0, 1, 2);
//		round.board.setBoard(0, 0, 2);
//		round.board.printBoardConsole();
//		System.out.println(Integer.toString(round.isWon()));
//		match.refreshScore(round.isWon());
//		match.printScore();

//		System.out.println(round.board.field[0][0].getFieldValue() == 1 && round.board.field[1][0].getFieldValue() == 1
//				&& round.board.field[2][0].getFieldValue() == 1);
//

		// Test: Computer vs. Computer
		// Match match = new Match(2,1);

//		// while (round.isEnd() != true && round.getCountMoves() < 9) {
//		System.out.println("Es beginnt Spieler " + match.getBeginner());
//		int AIfeld = 0;
////		if (AIfeld == 0) {
////			roundTest.setEnd(true);
////			System.out.println(roundTest.isWon());
////		}
//		int x;
//		int y;
//		// Zug 1
//		System.out.println("Zug 1");
//		System.out.println("CountMoves " + roundTest.getCountMoves());
//		AIfeld = computer1.AIZug(roundTest);
//		x = (AIfeld - 1) % 3;
//		y = (AIfeld - 1) / 3;
//		roundTest.board.setBoard(x, y, roundTest.getPlayerTurn(), roundTest);
//		roundTest.board.printBoardConsole();
//		roundTest.changeTurn();
//
//		// Zug2
//		System.out.println("Zug 2");
//		System.out.println("CountMoves " + roundTest.getCountMoves());
//		AIfeld = computer2.AIZug(roundTest);
//		x = (AIfeld - 1) % 3;
//		y = (AIfeld - 1) / 3;
//		roundTest.board.setBoard(x, y, roundTest.getPlayerTurn(), roundTest);
//		roundTest.board.printBoardConsole();
//		roundTest.changeTurn();
//
//		// Zug3
//		System.out.println("Zug 3");
//		System.out.println("CountMoves " + roundTest.getCountMoves());
//		AIfeld = computer1.AIZug(roundTest);
//		x = (AIfeld - 1) % 3;
//		y = (AIfeld - 1) / 3;
//		roundTest.board.setBoard(x, y, roundTest.getPlayerTurn(), roundTest);
//		roundTest.board.printBoardConsole();
//		roundTest.changeTurn();
//
//		// Zug4
//		System.out.println("Zug 4");
//		System.out.println("CountMoves " + roundTest.getCountMoves());
//		AIfeld = computer2.AIZug(roundTest);
//		x = (AIfeld - 1) % 3;
//		y = (AIfeld - 1) / 3;
//		roundTest.board.setBoard(x, y, roundTest.getPlayerTurn(), roundTest);
//		roundTest.board.printBoardConsole();
//		roundTest.changeTurn();
//
//		// Zug5
//		System.out.println("Zug 5");
//		System.out.println("CountMoves " + roundTest.getCountMoves());
//		AIfeld = computer1.AIZug(roundTest);
//		x = (AIfeld - 1) % 3;
//		y = (AIfeld - 1) / 3;
//		roundTest.board.setBoard(x, y, roundTest.getPlayerTurn(), roundTest);
//		roundTest.board.printBoardConsole();
//		if (roundTest.isWon() > 0)
//			return;
//		roundTest.changeTurn();
//
//		// Zug6
//		System.out.println("Zug 6");
//		System.out.println("CountMoves " + roundTest.getCountMoves());
//		AIfeld = computer2.AIZug(roundTest);
//		x = (AIfeld - 1) % 3;
//		y = (AIfeld - 1) / 3;
//		roundTest.board.setBoard(x, y, roundTest.getPlayerTurn(), roundTest);
//		roundTest.board.printBoardConsole();
//		if (roundTest.isWon() > 0)
//			return;
//		roundTest.changeTurn();
//
//		// Zug7
//		System.out.println("Zug 7");
//		System.out.println("CountMoves " + roundTest.getCountMoves());
//		AIfeld = computer1.AIZug(roundTest);
//		x = (AIfeld - 1) % 3;
//		y = (AIfeld - 1) / 3;
//		roundTest.board.setBoard(x, y, roundTest.getPlayerTurn(), roundTest);
//		roundTest.board.printBoardConsole();
//		if (roundTest.isWon() > 0)
//			return;
//		roundTest.changeTurn();
//
//		// Zug8
//		System.out.println("Zug 8");
//		System.out.println("CountMoves " + roundTest.getCountMoves());
//		AIfeld = computer2.AIZug(roundTest);
//		x = (AIfeld - 1) % 3;
//		y = (AIfeld - 1) / 3;
//		roundTest.board.setBoard(x, y, roundTest.getPlayerTurn(), roundTest);
//		roundTest.board.printBoardConsole();
//		if (roundTest.isWon() > 0)
//			return;
//		roundTest.changeTurn();
//
//		// Zug9
//		System.out.println("Zug 9");
//		System.out.println("CountMoves " + roundTest.getCountMoves());
//		AIfeld = computer1.AIZug(roundTest);
//		x = (AIfeld - 1) % 3;
//		y = (AIfeld - 1) / 3;
//		roundTest.board.setBoard(x, y, roundTest.getPlayerTurn(), roundTest);
//		roundTest.board.printBoardConsole();
//		if (roundTest.isWon() > 0)
//			return;
//		roundTest.changeTurn();
//
//		match.printScore();
//		roundTest.board.printBoardConsole();

// Spiel Computer vs Computer
//		computer.Zug1(round);
//		computer.Zug2(round);
//		computer.Zug3(round);
//		computer.Zug4(round);
//		computer.Zug5(round);
//		computer.Zug6(round);
//		computer.Zug7(round);
//		computer.Zug8(round);
//		computer.Zug9(round);

	}

	// MatchType = 2 C vs. C
	public static void matchType2(Match match, Round round) {
		System.out.println("Es beginnt Computer " + match.getBeginner());
		int AIfeld = 0;
		int x;
		int y;
		for (int i = 1; i < 10; i++) {
			System.out.println("Zug " + i); // Bugfixing
			//if (round.getPlayerTurn() == 1) {

				AIfeld = Computer.AIZug(round);
				x = (AIfeld - 1) % 3;
				y = (AIfeld - 1) / 3;
				round.board.setBoard(x, y, round.getPlayerTurn(), round);
				round.board.printBoardConsole();
				if (round.isWon()) {
					return;
					
					}
				round.changeTurn();
			//}
				
				
		}
		
	}
	

	private static void showmainmenu() {
		String[] stringmainmenu = new String[] { "Tic-Tac-Toe", "Mensch gegen Mensch", "Mensch vs Computer",
				"Computer vs Computer" };
		controls.Display.drawStringpkg(stringmainmenu);
	}

	// Init
	// Main Menu
	// Abfrage: Human vs. Human oder Human vs. Computer
	// Abfrage: Wer f�ngt an
	// New Match
	// New Round
	// New Board
	// (class Control) warte auf Eingabe
	// (class Logic) Logic ->> valid?
	// (class Board) Draw()
	// (class Display) Round "O is next"--> Display LCD.print"O is next"
	// (class Logic) Pr�fung, ob gewonnen
	// (Control/class Input) freigegeben
	// (Logic/ Display) "Noch ein Spiel?" (ja-> resetBoard(), nein -> MainMenu)
	// (class Input) Verarbeitung Eingabe

}
